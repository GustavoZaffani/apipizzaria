package br.edu.utfpr.apppizzariaapi.domain.ingredient.usecases;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.entities.Ingredient;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.requests.IngredientUpdateRequest;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.responses.IngredientDefaultResponse;
import br.edu.utfpr.apppizzariaapi.infra.exceptions.RegisterNotFoundException;
import br.edu.utfpr.apppizzariaapi.infra.ingredient.repositories.IngredientRepository;
import br.edu.utfpr.apppizzariaapi.infra.translation.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static br.edu.utfpr.apppizzariaapi.infra.translation.constants.TranslationConstants.INGREDIENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class IngredientUpdate {

    private final IngredientRepository ingredientRepository;
    private final TranslationService translationService;

    public IngredientDefaultResponse update(UUID id, IngredientUpdateRequest request) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException(translationService.getMessage(INGREDIENT_NOT_FOUND)));

        ingredient.update(request);

        return IngredientDefaultResponse.fromEntity(ingredientRepository.save(ingredient));
    }
}
