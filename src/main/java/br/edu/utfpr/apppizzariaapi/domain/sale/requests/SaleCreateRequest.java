package br.edu.utfpr.apppizzariaapi.domain.sale.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record SaleCreateRequest(
        @NotNull
        UUID pizzeriaId,
        @NotEmpty
        @Valid
        List<SaleItemCreateRequest> saleItems) {
}