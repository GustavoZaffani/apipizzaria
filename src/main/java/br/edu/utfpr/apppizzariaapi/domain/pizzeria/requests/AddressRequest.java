package br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.enumerations.State;
import jakarta.validation.constraints.NotBlank;

public record AddressRequest(
        @NotBlank
        String zipCode,
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        String city,
        String number,
        @NotBlank

        State state,
        @NotBlank
        String complement
) {
}
