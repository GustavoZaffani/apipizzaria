package br.edu.utfpr.apppizzariaapi.infra.controller;

import br.edu.utfpr.apppizzariaapi.infra.controller.responses.ErrorData;
import br.edu.utfpr.apppizzariaapi.infra.controller.responses.ErrorField;
import br.edu.utfpr.apppizzariaapi.infra.exceptions.AuthenticationApiException;
import br.edu.utfpr.apppizzariaapi.infra.exceptions.BadRequestException;
import br.edu.utfpr.apppizzariaapi.infra.exceptions.RegisterNotFoundException;
import br.edu.utfpr.apppizzariaapi.infra.translation.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static br.edu.utfpr.apppizzariaapi.infra.translation.constants.TranslationConstants.REGISTER_INVALID_FIELDS;

@RestControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvice {

    private final TranslationService translationService;

    @ExceptionHandler(RegisterNotFoundException.class)
    public ResponseEntity handleRegisterNotFound(RegisterNotFoundException ex) {
        ErrorData error = ErrorData.builder()
                .title(translationService.getMessage(ex.getTitle()))
                .message(ex.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ErrorData error = ErrorData.builder()
                .title(translationService.getMessage(REGISTER_INVALID_FIELDS))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .fieldErrors(ex.getFieldErrors().stream().map(ErrorField::fromFieldError).toList())
                .build();

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleInternalError(Exception ex) {
        ErrorData error = ErrorData.builder()
                .title("Inexpected error")
                .message(ex.getLocalizedMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }

    @ExceptionHandler(AuthenticationApiException.class)
    public ResponseEntity handleAuthenticationApiException(AuthenticationApiException ex) {
        ErrorData error = ErrorData.builder()
                .title(translationService.getMessage(ex.getTitle()))
                .message(ex.getMessage())
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .build();

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(error);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity handleBadRequestException(BadRequestException ex) {
        ErrorData error = ErrorData.builder()
                .title(translationService.getMessage(ex.getTitle()))
                .message(ex.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
