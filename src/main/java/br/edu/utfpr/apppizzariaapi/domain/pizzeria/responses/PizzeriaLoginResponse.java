package br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Pizzeria;
import lombok.Builder;

import java.util.UUID;

@Builder
public record PizzeriaLoginResponse(
        UUID id,
        String name) {

    public static PizzeriaLoginResponse fromEntity(Pizzeria pizzeria) {
        return PizzeriaLoginResponse.builder()
                .id(pizzeria.getId())
                .name(pizzeria.getName())
                .build();
    }
}
