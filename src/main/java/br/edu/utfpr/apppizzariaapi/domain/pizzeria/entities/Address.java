package br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.enumerations.State;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.AddressRequest;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static io.micrometer.common.util.StringUtils.isNotBlank;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;

    private String neighborhood;

    private String zipCode;

    private String number;

    private String complement;

    private String city;

    @Enumerated(EnumType.STRING)
    private State state;

    public Address(AddressRequest address) {
        this.street = address.street();
        this.neighborhood = address.neighborhood();
        this.zipCode = address.zipCode();
        this.number = address.number();
        this.complement = address.complement();
        this.city = address.city();
        this.state = address.state();
    }

    public void update(AddressRequest address) {
        if (isNotBlank(address.street())) {
            this.street = address.street();
        }

        if (isNotBlank(address.neighborhood())) {
            this.neighborhood = address.neighborhood();
        }

        if (isNotBlank(address.zipCode())) {
            this.zipCode = address.zipCode();
        }

        if (isNotBlank(address.number())) {
            this.number = address.number();
        }

        if (isNotBlank(address.complement())) {
            this.complement = address.complement();
        }

        if (isNotBlank(address.city())) {
            this.city = address.city();
        }

        if (address.state() != null) {
            this.state = address.state();
        }
    }

    public String getFullAddress() {
        return street + ", " +
                number + " - " +
                neighborhood + ", " +
                city + " - " +
                state + ", " +
                zipCode;
    }
}
