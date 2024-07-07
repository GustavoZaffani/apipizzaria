package br.edu.utfpr.apppizzariaapi.domain.pizza.responses;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.responses.IngredientDefaultResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizza.entities.Pizza;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record PizzaDefaultResponse(
        UUID id,
        String name,
        BigDecimal price,
        List<PizzaIngredientDefaultResponse> ingredients
) {

    public static List<PizzaDefaultResponse> fromEntities(List<Pizza> pizzas) {
        return pizzas.stream()
                .map(PizzaDefaultResponse::fromEntity)
                .toList();
    }

    public static PizzaDefaultResponse fromEntity(Pizza pizza) {
        return new PizzaDefaultResponse(
                pizza.getId(),
                pizza.getName(),
                pizza.getPrice(),
                PizzaIngredientDefaultResponse.fromEntities(pizza.getIngredients())
        );
    }
}
