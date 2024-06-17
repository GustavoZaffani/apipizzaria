package br.edu.utfpr.apppizzariaapi.infra.validators.annotations;

import br.edu.utfpr.apppizzariaapi.infra.validators.LoginValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginValidator.class)
public @interface Login {

    String message() default "{login.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
