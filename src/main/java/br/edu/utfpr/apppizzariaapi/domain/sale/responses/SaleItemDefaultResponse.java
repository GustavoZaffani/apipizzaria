package br.edu.utfpr.apppizzariaapi.domain.sale.responses;

import br.edu.utfpr.apppizzariaapi.domain.sale.entities.SaleItem;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record SaleItemDefaultResponse(
        UUID id,
        UUID pizzaId,
        String pizzaName,
        Long quantity
) {
    public static List<SaleItemDefaultResponse> fromEntities(List<SaleItem> saleItems) {
        return saleItems.stream()
                .map(SaleItemDefaultResponse::fromEntity)
                .toList();
    }

    private static SaleItemDefaultResponse fromEntity(SaleItem saleItem) {
        return SaleItemDefaultResponse.builder()
                .id(saleItem.getId())
                .pizzaId(saleItem.getPizza().getId())
                .pizzaName(saleItem.getPizza().getName())
                .quantity(saleItem.getQuantity())
                .build();
    }
}
