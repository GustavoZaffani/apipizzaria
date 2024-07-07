package br.edu.utfpr.apppizzariaapi.domain.sale.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.util.UUID;

@Builder
public record SaleItemCreateRequest(
        @NotNull
        UUID pizzaId,
        @Positive
        Long quantity
) {
}
