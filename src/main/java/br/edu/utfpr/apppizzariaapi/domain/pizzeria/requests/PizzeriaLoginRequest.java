package br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests;

import jakarta.validation.constraints.NotBlank;

public record PizzeriaLoginRequest(
        @NotBlank
        String login,
        @NotBlank
        String password) {
}
