package br.edu.utfpr.apppizzariaapi.infra.controller.responses;

import lombok.Builder;
import org.springframework.validation.FieldError;

@Builder
public record ErrorField(
        String field,
        String error
) {

    public static ErrorField fromFieldError(FieldError fieldError) {
        return ErrorField.builder()
                .field(fieldError.getField())
                .error(fieldError.getDefaultMessage())
                .build();
    }
}
