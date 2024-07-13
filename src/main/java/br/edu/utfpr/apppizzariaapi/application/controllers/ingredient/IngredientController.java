package br.edu.utfpr.apppizzariaapi.application.controllers.ingredient;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.requests.IngredientCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.requests.IngredientUpdateRequest;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.responses.IngredientDefaultResponse;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.usecases.IngredientCreate;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.usecases.IngredientList;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.usecases.IngredientRetrieve;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.usecases.IngredientUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/ingredients")
public class IngredientController {

    private final IngredientList ingredientList;
    private final IngredientCreate ingredientCreate;
    private final IngredientUpdate ingredientUpdate;
    private final IngredientRetrieve ingredientRetrieve;

    @PostMapping
    public ResponseEntity<IngredientDefaultResponse> create(@Valid @RequestBody IngredientCreateRequest request) {
        return ResponseEntity.ok(ingredientCreate.create(request));
    }

    @GetMapping
    public ResponseEntity<List<IngredientDefaultResponse>> findAll(@RequestParam(value = "ingredientName", required = false) String ingredientName) {
        return ResponseEntity.ok(ingredientList.list(ingredientName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientDefaultResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(ingredientRetrieve.retrieve(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<IngredientDefaultResponse> update(@PathVariable UUID id,
                                                            @Valid @RequestBody IngredientUpdateRequest request) {
        return ResponseEntity.ok(ingredientUpdate.update(id, request));
    }
}
