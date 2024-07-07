package br.edu.utfpr.apppizzariaapi.domain.pizza.requests;

import jakarta.validation.constraints.Positive;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Builder
public record PizzaUpdateRequest(
        @Length(max = 255, message = "{pizza-register.name-is-max-length}")
        String name,
        @Positive(message = "{pizza-register.price-is-positive}")
        BigDecimal price
) {
}
