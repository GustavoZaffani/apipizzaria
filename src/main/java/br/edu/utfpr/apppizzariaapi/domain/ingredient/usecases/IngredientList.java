package br.edu.utfpr.apppizzariaapi.domain.ingredient.usecases;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.responses.IngredientDefaultResponse;
import br.edu.utfpr.apppizzariaapi.infra.cache.AuthenticationContext;
import br.edu.utfpr.apppizzariaapi.infra.ingredient.repositories.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IngredientList {

    private final IngredientRepository ingredientRepository;

    public List<IngredientDefaultResponse> list() {
        return IngredientDefaultResponse.fromEntities(ingredientRepository.findAllByPizzeriaId(
                AuthenticationContext.getPizzeriaId()
        ));
    }
}
