package br.edu.utfpr.apppizzariaapi.domain.ingredient.usecases;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.entities.Ingredient;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.requests.IngredientCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.responses.IngredientDefaultResponse;
import br.edu.utfpr.apppizzariaapi.infra.ingredient.repositories.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class IngredientCreate {

    private final IngredientRepository ingredientRepository;

    public IngredientDefaultResponse create(IngredientCreateRequest request) {
        Ingredient ingredient = new Ingredient(request);

        return IngredientDefaultResponse.fromEntity(ingredientRepository.save(ingredient));
    }
}
