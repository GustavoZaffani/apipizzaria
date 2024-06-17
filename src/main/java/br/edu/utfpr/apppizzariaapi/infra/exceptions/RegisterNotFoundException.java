package br.edu.utfpr.apppizzariaapi.infra.exceptions;

import lombok.Getter;

@Getter
public class RegisterNotFoundException extends RuntimeException {

    private final String title = "register.not-found";

    public RegisterNotFoundException(String message) {
        super(message);
    }
}
