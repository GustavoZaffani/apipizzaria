package br.edu.utfpr.apppizzariaapi.domain.ingredient.requests;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.enumerations.MeasurementUnit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record IngredientCreateRequest(
        @NotBlank(message = "{ingredient-register.name-is-blank}")
        String name,
        @NotBlank(message = "{ingredient-register.description-is-blank}")
        String description,
        @NotNull(message = "{ingredient-register.price-is-null}")
        @Positive(message = "{ingredient-register.price-is-positive}")
        BigDecimal price,
        @NotNull(message = "{ingredient-register.measurement-unit-is-null}")
        MeasurementUnit measurementUnit,
        @NotNull(message = "{ingredient-register.quantity-is-null}")
        @Positive(message = "{ingredient-register.quantity-is-positive}")
        BigDecimal quantity
) {
}
