package br.edu.utfpr.apppizzariaapi.infra.controller.responses;

import lombok.Builder;

import java.util.List;

@Builder
public record ErrorData(
        String title,
        String message,
        int statusCode,
        List<ErrorField> fieldErrors) {
}
