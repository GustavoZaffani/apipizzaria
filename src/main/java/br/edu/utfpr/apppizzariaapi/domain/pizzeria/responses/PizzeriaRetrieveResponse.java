package br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Pizzeria;

import java.util.UUID;

public record PizzeriaRetrieveResponse(
        UUID id,
        String name,
        AddressResponse address,
        String phone,
        String email,
        String login
) {
    public static PizzeriaRetrieveResponse fromEntity(Pizzeria pizzeria) {
        return new PizzeriaRetrieveResponse(
                pizzeria.getId(),
                pizzeria.getName(),
                AddressResponse.fromEntity(pizzeria.getAddress()),
                pizzeria.getPhone(),
                pizzeria.getEmail(),
                pizzeria.getLogin()
        );
    }

}
