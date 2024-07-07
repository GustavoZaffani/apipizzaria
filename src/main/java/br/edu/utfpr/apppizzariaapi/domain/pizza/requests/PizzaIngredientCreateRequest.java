package br.edu.utfpr.apppizzariaapi.domain.pizza.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record PizzaIngredientCreateRequest(
        @NotNull
        UUID ingredientId,

        @NotNull
        @Positive
        BigDecimal quantity
) {
}
