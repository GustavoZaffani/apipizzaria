package br.edu.utfpr.apppizzariaapi.domain.pizza.usecases;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.entities.Ingredient;
import br.edu.utfpr.apppizzariaapi.domain.pizza.entities.Pizza;
import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaIngredientCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizza.responses.PizzaDefaultResponse;
import br.edu.utfpr.apppizzariaapi.infra.exceptions.BadRequestException;
import br.edu.utfpr.apppizzariaapi.infra.ingredient.repositories.IngredientRepository;
import br.edu.utfpr.apppizzariaapi.infra.pizza.repositories.PizzaRepository;
import br.edu.utfpr.apppizzariaapi.infra.translation.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static br.edu.utfpr.apppizzariaapi.infra.translation.constants.TranslationConstants.PIZZA_INGREDIENTS_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class PizzaCreate {

    private final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;
    private final TranslationService translationService;

    public PizzaDefaultResponse create(PizzaCreateRequest request) {
        validateIngredients(request.ingredients());
        return PizzaDefaultResponse.fromEntity(pizzaRepository.save(new Pizza(request)));
    }

    private void validateIngredients(List<PizzaIngredientCreateRequest> pizzaIngredients) {
        List<UUID> ingredientsIds = pizzaIngredients.stream()
                .map(PizzaIngredientCreateRequest::ingredientId)
                .toList();

        List<Ingredient> ingredients = ingredientRepository.findAllById(ingredientsIds);

        if (ingredients.size() != ingredientsIds.size()) {
            throw new BadRequestException(translationService.getMessage(PIZZA_INGREDIENTS_NOT_FOUND));
        }

    }
}
