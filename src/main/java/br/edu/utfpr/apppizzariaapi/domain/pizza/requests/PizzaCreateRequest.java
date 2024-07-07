package br.edu.utfpr.apppizzariaapi.domain.pizza.requests;

import jakarta.validation.Valid;
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
        @NotBlank(message = "{pizza-register.name-is-blank}")
        @Length(max = 255, message = "{pizza-register.name-is-max-length}")
        String name,
        @NotNull(message = "{pizza-register.price-is-null}")
        @Positive(message = "{pizza-register.price-is-positive}")
        BigDecimal price,
        @Valid
        @NotEmpty(message = "{pizza-register.ingredients-is-empty}")
        List<PizzaIngredientCreateRequest> ingredients
) {
}
