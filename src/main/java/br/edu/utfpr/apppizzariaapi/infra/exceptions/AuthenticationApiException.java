package br.edu.utfpr.apppizzariaapi.infra.exceptions;

import lombok.Getter;

@Getter
public class AuthenticationApiException extends RuntimeException {

    private final String title = "auth.error";

    public AuthenticationApiException(String message) {
        super(message);
    }
}
