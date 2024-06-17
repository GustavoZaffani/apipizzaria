package br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Address;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.enumerations.State;

public record AddressResponse(
        String zipCode,
        String street,
        String neighborhood,
        String city,
        String number,
        State state,
        String complement
) {
    public static AddressResponse fromEntity(Address address) {
        return new AddressResponse(
                address.getZipCode(),
                address.getStreet(),
                address.getNeighborhood(),
                address.getCity(),
                address.getNumber(),
                address.getState(),
                address.getComplement()
        );
    }
}
