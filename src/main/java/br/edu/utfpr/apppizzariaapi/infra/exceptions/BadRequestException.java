package br.edu.utfpr.apppizzariaapi.infra.exceptions;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private final String title = "generic.error-on-processing-data";

    public BadRequestException(String message) {
        super(message);
    }
}
