package br.edu.utfpr.apppizzariaapi.infra.validators;

import br.edu.utfpr.apppizzariaapi.infra.validators.annotations.Phone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || value.isEmpty() || value.matches("^(\\(\\d{2}\\)|\\d{2})\\s?9?\\d{4}\\-?\\d{4}$");
    }
}

