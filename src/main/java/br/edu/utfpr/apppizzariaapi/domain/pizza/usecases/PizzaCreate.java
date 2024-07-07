package br.edu.utfpr.apppizzariaapi.domain.pizza.usecases;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.entities.Ingredient;
import br.edu.utfpr.apppizzariaapi.domain.pizza.entities.Pizza;
import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaIngredientCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizza.responses.PizzaDefaultResponse;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.IngredientRepository;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PizzaCreate {

    private final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;

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
            throw new RuntimeException("Ingredient not found");
        }

    }
}
