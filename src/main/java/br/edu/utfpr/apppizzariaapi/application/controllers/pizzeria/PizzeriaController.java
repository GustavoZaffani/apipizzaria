package br.edu.utfpr.apppizzariaapi.application.controllers.pizzeria;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaLoginRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaUpdateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaListResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaLoginResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaRetrieveResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaSaveResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.usecases.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/pizzerias")
public class PizzeriaController {

    private final PizzeriaList pizzeriaList;
    private final PizzeriaCreate pizzeriaCreate;
    private final PizzeriaUpdate pizzeriaUpdate;
    private final PizzeriaRetrieve pizzeriaRetrieve;
    private final PizzeriaLogin pizzeriaLogin;
    private final PizzeriaDelete pizzeriaDelete;

    @PostMapping
    public ResponseEntity<PizzeriaSaveResponse> create(@Valid @RequestBody PizzeriaCreateRequest request) {
        return ResponseEntity.ok(pizzeriaCreate.create(request));
    }

    @GetMapping
    public ResponseEntity<List<PizzeriaListResponse>> findAll(@RequestParam(value = "name", required = false) String name) {
        return ResponseEntity.ok(pizzeriaList.list(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzeriaRetrieveResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(pizzeriaRetrieve.retrieve(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PizzeriaSaveResponse> update(@PathVariable UUID id,
                                                       @Valid @RequestBody PizzeriaUpdateRequest request) {
        return ResponseEntity.ok(pizzeriaUpdate.update(id, request));
    }

    @PostMapping("/login")
    public ResponseEntity<PizzeriaLoginResponse> login(@Valid @RequestBody PizzeriaLoginRequest request) {
        return ResponseEntity.ok(pizzeriaLogin.login(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        pizzeriaDelete.delete(id);
        return ResponseEntity.noContent().build();
    }
}
