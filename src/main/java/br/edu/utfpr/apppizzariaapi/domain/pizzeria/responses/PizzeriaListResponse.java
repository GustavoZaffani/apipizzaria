package br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Pizzeria;
import lombok.Builder;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Builder
public record PizzeriaListResponse(
        UUID id,
        String name,
        String address,
        String phone,
        String email) {

    public static List<PizzeriaListResponse> fromEntities(List<Pizzeria> pizzerias) {
        return pizzerias.stream()
                .map(PizzeriaListResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public static PizzeriaListResponse fromEntity(Pizzeria pizzeria) {
        return PizzeriaListResponse.builder()
                .id(pizzeria.getId())
                .name(pizzeria.getName())
                .address(pizzeria.getAddress().getFullAddress())
                .phone(pizzeria.getPhone())
                .email(pizzeria.getEmail())
                .build();
    }
}
