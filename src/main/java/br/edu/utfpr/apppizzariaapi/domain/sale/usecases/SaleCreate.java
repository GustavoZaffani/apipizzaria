package br.edu.utfpr.apppizzariaapi.domain.sale.usecases;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.entities.Ingredient;
import br.edu.utfpr.apppizzariaapi.domain.pizza.entities.Pizza;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Pizzeria;
import br.edu.utfpr.apppizzariaapi.domain.sale.entities.Sale;
import br.edu.utfpr.apppizzariaapi.domain.sale.requests.SaleCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.sale.requests.SaleItemCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.sale.responses.SaleDefaultResponse;
import br.edu.utfpr.apppizzariaapi.infra.exceptions.RegisterNotFoundException;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.IngredientRepository;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzaRepository;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzeriaRepository;
import br.edu.utfpr.apppizzariaapi.infra.sale.repositories.SaleRepository;
import br.edu.utfpr.apppizzariaapi.infra.translation.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static br.edu.utfpr.apppizzariaapi.domain.ingredient.constants.TranslationConstants.INGREDIENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class SaleCreate {

    private final SaleRepository saleRepository;
    private final PizzaRepository pizzaRepository;
    private final PizzeriaRepository pizzeriaRepository;
    private final TranslationService translationService;
    private final IngredientRepository ingredientRepository;

    @Transactional
    public SaleDefaultResponse create(SaleCreateRequest request) {
        Pizzeria pizzeria = validatePizzeria(request.pizzeriaId());

        Set<UUID> pizzasId = getPizzasId(request);

        Map<UUID, Pizza> pizzaMap = pizzaRepository.findAllById(pizzasId).stream()
                .collect(Collectors.toMap(Pizza::getId, Function.identity()));

        if (pizzaMap.size() < pizzasId.size()) {
            throw new RuntimeException("Uma ou mais pizzas não foram encontradas.");
        }

        changeIngredientsQuantity(request, pizzaMap);

        return SaleDefaultResponse.fromEntity(saleRepository.save(new Sale(pizzeria, request.saleItems(), pizzaMap)));
    }

    private void changeIngredientsQuantity(SaleCreateRequest request, Map<UUID, Pizza> pizzaMap) {
        request.saleItems().forEach(saleItem -> {
            Pizza pizza = pizzaMap.get(saleItem.pizzaId());

            List<Ingredient> ingredients = new LinkedList<>();

            pizza.getIngredients().forEach(pizzaIngredient -> {
                BigDecimal ingredientQuantityToSubtract = pizzaIngredient.getQuantity().multiply(BigDecimal.valueOf(saleItem.quantity()));
                BigDecimal newQuantity = pizzaIngredient.getIngredient().getQuantity().subtract(ingredientQuantityToSubtract);

                if (newQuantity.compareTo(BigDecimal.ZERO) < 0) {
                    throw new RuntimeException("Ingrediente insuficiente.");
                }

                pizzaIngredient.getIngredient().setQuantity(newQuantity);

                ingredients.add(pizzaIngredient.getIngredient());
            });

            ingredientRepository.saveAll(ingredients);
        });
    }

    private static Set<UUID> getPizzasId(SaleCreateRequest request) {
        return request.saleItems().stream()
                .map(SaleItemCreateRequest::pizzaId)
                .collect(Collectors.toSet());
    }

    private Pizzeria validatePizzeria(UUID pizzeriaId) {
        return pizzeriaRepository.findById(pizzeriaId)
                .orElseThrow(() -> new RegisterNotFoundException(translationService.getMessage(INGREDIENT_NOT_FOUND))); // TODO: Create translation
    }


}
