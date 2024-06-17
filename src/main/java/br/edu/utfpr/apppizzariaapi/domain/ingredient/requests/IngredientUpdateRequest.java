package br.edu.utfpr.apppizzariaapi.domain.ingredient.requests;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record IngredientUpdateRequest(
        String name,
        String description,
        @Positive
        BigDecimal price
) {
}
