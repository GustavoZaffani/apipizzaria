package br.edu.utfpr.apppizzariaapi.domain.sale.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record SaleCreateRequest(
        @NotEmpty(message = "{sale-register.sale-items-is-blank}")
        @Valid
        List<SaleItemCreateRequest> saleItems) {
}
