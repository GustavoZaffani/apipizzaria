package br.edu.utfpr.apppizzariaapi.domain.ingredient.responses;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.entities.Ingredient;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.enumerations.MeasurementUnit;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
public record IngredientDefaultResponse(
        UUID id,
        String name,
        String description,
        BigDecimal price,
        MeasurementUnit measurementUnit,
        BigDecimal quantity
) {
    public static List<IngredientDefaultResponse> fromEntities(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(IngredientDefaultResponse::fromEntity)
                .toList();
    }

    public static IngredientDefaultResponse fromEntity(Ingredient ingredient) {
        return IngredientDefaultResponse.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .description(ingredient.getDescription())
                .price(ingredient.getPrice())
                .measurementUnit(ingredient.getMeasurementUnit())
                .quantity(ingredient.getQuantity())
                .build();
    }
}
