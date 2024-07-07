package br.edu.utfpr.apppizzariaapi.domain.pizza.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record PizzaIngredientCreateRequest(
        @NotNull(message = "{pizza-register.ingredient-id-is-null}")
        UUID ingredientId,
        @NotNull(message = "{pizza-register.ingredient-quantity-is-null}")
        @Positive(message = "{pizza-register.ingredient-quantity-is-positive}")
        BigDecimal quantity
) {
}
