package br.edu.utfpr.apppizzariaapi.domain.pizza.responses;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.enumerations.MeasurementUnit;
import br.edu.utfpr.apppizzariaapi.domain.pizza.entities.PizzaIngredient;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
public record PizzaIngredientDefaultResponse(
        UUID id,
        UUID ingredientId,
        String ingredientName,
        MeasurementUnit measurementUnit,
        BigDecimal quantity
) {
    public static List<PizzaIngredientDefaultResponse> fromEntities(List<PizzaIngredient> ingredients) {
        return ingredients.stream()
                .map(PizzaIngredientDefaultResponse::fromEntity)
                .toList();
    }

    public static PizzaIngredientDefaultResponse fromEntity(PizzaIngredient ingredient) {
        return PizzaIngredientDefaultResponse.builder()
                .id(ingredient.getId())
                .ingredientId(ingredient.getIngredient().getId())
                .ingredientName(ingredient.getIngredient().getName())
                .measurementUnit(ingredient.getIngredient().getMeasurementUnit())
                .quantity(ingredient.getQuantity())
                .build();
    }
}
