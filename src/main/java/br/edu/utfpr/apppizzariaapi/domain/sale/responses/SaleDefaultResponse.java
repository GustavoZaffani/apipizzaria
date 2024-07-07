package br.edu.utfpr.apppizzariaapi.domain.sale.responses;

import br.edu.utfpr.apppizzariaapi.domain.sale.entities.Sale;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record SaleDefaultResponse(
        UUID id,
        List<SaleItemDefaultResponse> saleItems,
        LocalDateTime saleDate,
        BigDecimal total
) {

    public static List<SaleDefaultResponse> fromEntities(List<Sale> sales) {
        return sales.stream()
                .map(SaleDefaultResponse::fromEntity)
                .toList();
    }

    public static SaleDefaultResponse fromEntity(Sale sale) {
        return SaleDefaultResponse.builder()
                .id(sale.getId())
                .saleItems(SaleItemDefaultResponse.fromEntities(sale.getSaleItems()))
                .saleDate(sale.getSaleDate())
                .total(sale.getTotal())
                .build();
    }
}
