package br.edu.utfpr.apppizzariaapi.domain.pizza.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
public record PizzaCreateRequest(
        @NotBlank
        @Length(max = 255)
        String name,
        @NotNull
        @Positive
        BigDecimal price,
        @NotEmpty
        List<PizzaIngredientCreateRequest> ingredients
) {
}
