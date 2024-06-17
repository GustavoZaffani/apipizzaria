package br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Pizzeria;
import lombok.Builder;

import java.util.UUID;

@Builder
public record PizzeriaSaveResponse(
        UUID id,
        String name,
        String phone,
        String email
) {
    public static PizzeriaSaveResponse fromEntity(Pizzeria pizzeria) {
        return PizzeriaSaveResponse.builder()
                .id(pizzeria.getId())
                .name(pizzeria.getName())
                .phone(pizzeria.getPhone())
                .email(pizzeria.getEmail())
                .build();
    }
}
