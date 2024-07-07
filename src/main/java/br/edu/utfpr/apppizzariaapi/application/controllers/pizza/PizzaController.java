package br.edu.utfpr.apppizzariaapi.application.controllers.pizza;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.responses.IngredientDefaultResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaUpdateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizza.responses.PizzaDefaultResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizza.usecases.PizzaCreate;
import br.edu.utfpr.apppizzariaapi.domain.pizza.usecases.PizzaList;
import br.edu.utfpr.apppizzariaapi.domain.pizza.usecases.PizzaRetrieve;
import br.edu.utfpr.apppizzariaapi.domain.pizza.usecases.PizzaUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/pizzas")
public class PizzaController {

    private final PizzaCreate pizzaCreate;
    private final PizzaUpdate pizzaUpdate;
    private final PizzaList pizzaList;
    private final PizzaRetrieve pizzaRetrieve;

    @PostMapping
    public ResponseEntity<PizzaDefaultResponse> create(@Valid @RequestBody PizzaCreateRequest request) {
        return ResponseEntity.ok(pizzaCreate.create(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PizzaDefaultResponse> update(@PathVariable UUID id,
                                                       @Valid @RequestBody PizzaUpdateRequest request) {
        return ResponseEntity.ok(pizzaUpdate.update(id, request));
    }

    @GetMapping
    public ResponseEntity<List<PizzaDefaultResponse>> findAll() {
        return ResponseEntity.ok(pizzaList.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaDefaultResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(pizzaRetrieve.retrieve(id));
    }

}
