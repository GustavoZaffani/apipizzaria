package br.edu.utfpr.apppizzariaapi.application.controllers.pizzeria;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaLoginRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaLoginResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaSaveResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.usecases.PizzeriaCreate;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.usecases.PizzeriaLogin;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/pizzerias")
public class PizzeriaController {

    private final PizzeriaCreate pizzeriaCreate;
    private final PizzeriaLogin pizzeriaLogin;

    @PostMapping
    public ResponseEntity<PizzeriaSaveResponse> create(@Valid @RequestBody PizzeriaCreateRequest request) {
        return ResponseEntity.ok(pizzeriaCreate.create(request));
    }

    @PostMapping("/login")
    public ResponseEntity<PizzeriaLoginResponse> login(@Valid @RequestBody PizzeriaLoginRequest request) {
        return ResponseEntity.ok(pizzeriaLogin.login(request));
    }
}
