package br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.enumerations.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record AddressRequest(
        @NotBlank(message = "{pizzeria-register.zipcode-is-blank}")
        @Length(max = 8, message = "{pizzeria-register.zipcode-is-max-length}")
        String zipCode,
        @NotBlank(message = "{pizzeria-register.street-is-blank}")
        @Length(max = 100, message = "{pizzeria-register.street-is-max-length}")
        String street,
        @NotBlank(message = "{pizzeria-register.neighborhood-is-blank}")
        @Length(max = 100, message = "{pizzeria-register.neighborhood-is-max-length}")
        String neighborhood,
        @NotBlank(message = "{pizzeria-register.city-is-blank}")
        @Length(max = 100, message = "{pizzeria-register.city-is-max-length}")
        String city,
        String number,
        @NotNull(message = "{pizzeria-register.state-is-null}")
        State state,
        @NotBlank(message = "{pizzeria-register.complement-is-blank}")
        @Length(max = 255, message = "{pizzeria-register.complement-is-max-length}")
        String complement
) {
}
