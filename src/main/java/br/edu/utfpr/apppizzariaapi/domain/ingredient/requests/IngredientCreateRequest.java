package br.edu.utfpr.apppizzariaapi.domain.ingredient.requests;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.enumerations.MeasurementUnit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record IngredientCreateRequest(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        @Positive
        BigDecimal price,
        @NotNull
        MeasurementUnit measurementUnit,
        @PositiveOrZero
        BigDecimal quantity
) {
}
