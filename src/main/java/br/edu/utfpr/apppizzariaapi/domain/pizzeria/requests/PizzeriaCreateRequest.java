package br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests;

import br.edu.utfpr.apppizzariaapi.infra.validators.annotations.Login;
import br.edu.utfpr.apppizzariaapi.infra.validators.annotations.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

@Builder
public record PizzeriaCreateRequest(
        @NotBlank
        @Length(max = 255)
        String name,
        @NotNull
        AddressRequest address,
        @NotBlank
        @Phone
        String phone,
        @NotBlank
        @Length(max = 100)
        @Email
        String email,
        @NotBlank
        @Length(max = 50)
        @Login
        String login,

        @NotBlank
        @Length(max = 50)
        String password){
}
