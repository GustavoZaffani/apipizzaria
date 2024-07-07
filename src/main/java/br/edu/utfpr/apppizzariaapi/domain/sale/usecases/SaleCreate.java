package br.edu.utfpr.apppizzariaapi.domain.sale.usecases;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.entities.Ingredient;
import br.edu.utfpr.apppizzariaapi.domain.pizza.entities.Pizza;
import br.edu.utfpr.apppizzariaapi.domain.sale.entities.Sale;
import br.edu.utfpr.apppizzariaapi.domain.sale.requests.SaleCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.sale.requests.SaleItemCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.sale.responses.SaleDefaultResponse;
import br.edu.utfpr.apppizzariaapi.infra.exceptions.BadRequestException;
import br.edu.utfpr.apppizzariaapi.infra.ingredient.repositories.IngredientRepository;
import br.edu.utfpr.apppizzariaapi.infra.pizza.repositories.PizzaRepository;
import br.edu.utfpr.apppizzariaapi.infra.sale.repositories.SaleRepository;
import br.edu.utfpr.apppizzariaapi.infra.translation.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static br.edu.utfpr.apppizzariaapi.infra.translation.constants.TranslationConstants.SALE_INSUFFICIENT_INGREDIENTS;
import static br.edu.utfpr.apppizzariaapi.infra.translation.constants.TranslationConstants.SALE_PIZZAS_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class SaleCreate {

    private final SaleRepository saleRepository;
    private final PizzaRepository pizzaRepository;
    private final TranslationService translationService;
    private final IngredientRepository ingredientRepository;

    @Transactional
    public SaleDefaultResponse create(SaleCreateRequest request) {
        Set<UUID> pizzasId = getPizzasId(request);

        Map<UUID, Pizza> pizzaMap = pizzaRepository.findAllById(pizzasId).stream()
                .collect(Collectors.toMap(Pizza::getId, Function.identity()));

        if (pizzaMap.size() < pizzasId.size()) {
            throw new BadRequestException(translationService.getMessage(SALE_PIZZAS_NOT_FOUND));
        }

        changeIngredientsQuantity(request, pizzaMap);

        return SaleDefaultResponse.fromEntity(saleRepository.save(new Sale(request, pizzaMap)));
    }

    private void changeIngredientsQuantity(SaleCreateRequest request, Map<UUID, Pizza> pizzaMap) {
        request.saleItems().forEach(saleItem -> {
            Pizza pizza = pizzaMap.get(saleItem.pizzaId());

            List<Ingredient> ingredients = new LinkedList<>();

            pizza.getIngredients().forEach(pizzaIngredient -> {
                BigDecimal ingredientQuantityToSubtract = pizzaIngredient.getQuantity().multiply(BigDecimal.valueOf(saleItem.quantity()));
                BigDecimal newQuantity = pizzaIngredient.getIngredient().getQuantity().subtract(ingredientQuantityToSubtract);

                if (newQuantity.compareTo(BigDecimal.ZERO) < 0) {
                    throw new BadRequestException(translationService.getMessage(SALE_INSUFFICIENT_INGREDIENTS));
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

}
