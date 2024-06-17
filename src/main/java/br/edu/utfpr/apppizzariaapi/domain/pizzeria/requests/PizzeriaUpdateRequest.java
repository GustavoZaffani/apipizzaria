package br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests;

import br.edu.utfpr.apppizzariaapi.infra.validators.annotations.Phone;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

@Builder
public record PizzeriaUpdateRequest(
        @Length(max = 255)
        String name,
        AddressRequest address,
        @Phone
        String phone,
        @Length(max = 100)
        @Email
        String email) {
}
