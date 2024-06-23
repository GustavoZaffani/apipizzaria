package br.edu.utfpr.apppizzariaapi.application.controllers.pizza;

import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaUpdateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizza.responses.PizzaSaveResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizza.usecases.PizzaCreate;
import br.edu.utfpr.apppizzariaapi.domain.pizza.usecases.PizzaUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/pizzas")
public class PizzaController {

    private final PizzaCreate pizzaCreate;
    private final PizzaUpdate pizzaUpdate;

    @PostMapping
    public ResponseEntity<PizzaSaveResponse> create(@Valid @RequestBody PizzaCreateRequest request) {
        return ResponseEntity.ok(pizzaCreate.create(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PizzaSaveResponse> update(@PathVariable UUID id,
                                                    @Valid @RequestBody PizzaUpdateRequest request) {
        return ResponseEntity.ok(pizzaUpdate.update(id, request));
    }
}
