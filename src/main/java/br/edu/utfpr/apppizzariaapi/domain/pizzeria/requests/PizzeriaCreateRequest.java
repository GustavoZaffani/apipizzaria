package br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests;

import br.edu.utfpr.apppizzariaapi.infra.validators.annotations.Login;
import br.edu.utfpr.apppizzariaapi.infra.validators.annotations.Phone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

@Builder
public record PizzeriaCreateRequest(
        @NotBlank(message = "{pizzeria-register.name-is-blank}")
        @Length(max = 255, message = "{pizzeria-register.name-is-max-length}")
        String name,
        @Valid
        @NotNull(message = "{pizzeria-register.address-is-null}")
        AddressRequest address,
        @NotBlank(message = "{pizzeria-register.phone-is-blank}")
        @Phone(message = "{pizzeria-register.phone-is-invalid}")
        String phone,
        @NotBlank(message = "{pizzeria-register.email-is-blank}")
        @Length(max = 100, message = "{pizzeria-register.email-is-max-length}")
        @Email(message = "{pizzeria-register.email-is-invalid}")
        String email,
        @NotBlank(message = "{pizzeria-register.login-is-blank}")
        @Length(max = 50, message = "{pizzeria-register.login-is-max-length}")
        @Login(message = "{pizzeria-register.login-is-invalid}")
        String login,
        @NotBlank(message = "{pizzeria-register.password-is-blank}")
        @Length(max = 50, message = "{pizzeria-register.password-is-max-length}")
        String password){
}
