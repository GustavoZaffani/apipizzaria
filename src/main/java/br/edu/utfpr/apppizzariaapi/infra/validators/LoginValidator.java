package br.edu.utfpr.apppizzariaapi.infra.validators;

import br.edu.utfpr.apppizzariaapi.infra.validators.annotations.Login;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LoginValidator implements ConstraintValidator<Login, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value == null || value.isEmpty() || value.matches("^[a-z]+$");
    }
}
