package br.edu.utfpr.apppizzariaapi.domain.pizza.responses;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.responses.IngredientDefaultResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizza.entities.Pizza;
import br.edu.utfpr.apppizzariaapi.domain.pizza.enumerations.SizePizza;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record PizzaSaveResponse(
        UUID id,
        String name,
        SizePizza size,
        BigDecimal price,
        List<IngredientDefaultResponse> ingredients
) {

    public static PizzaSaveResponse fromEntity(Pizza pizza) {
        return new PizzaSaveResponse(
                pizza.getId(),
                pizza.getName(),
                pizza.getSize(),
                pizza.getPrice(),
                IngredientDefaultResponse.fromEntities(pizza.getIngredients())
        );
    }
}
