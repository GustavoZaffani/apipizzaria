package br.edu.utfpr.apppizzariaapi.domain.sale.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.util.UUID;

@Builder
public record SaleItemCreateRequest(
        @NotNull(message = "{sale-register.sale-items-pizza-id-is-null}")
        UUID pizzaId,
        @NotNull(message = "{sale-register.sale-items-quantity-is-null}")
        @Positive(message = "{sale-register.sale-items-quantity-is-positive}")
        Long quantity
) {
}
