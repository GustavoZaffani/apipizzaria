package br.edu.utfpr.apppizzariaapi.domain.ingredient.usecases;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.responses.IngredientDefaultResponse;
import br.edu.utfpr.apppizzariaapi.infra.cache.AuthenticationContext;
import br.edu.utfpr.apppizzariaapi.infra.ingredient.repositories.IngredientRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static io.micrometer.common.util.StringUtils.isNotBlank;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IngredientList {

    private static final String LIKE_OPERATOR = "%";
    private final IngredientRepository ingredientRepository;

    public List<IngredientDefaultResponse> list(String ingredientName) {
        var pizzeriaId = AuthenticationContext.getPizzeriaId();

        var ingredients = isNotBlank(ingredientName) ?
                ingredientRepository.findAllByPizzeriaIdAndNameLikeIgnoreCase(
                        pizzeriaId,
                        LIKE_OPERATOR + ingredientName + LIKE_OPERATOR
                ) :
                ingredientRepository.findAllByPizzeriaId(pizzeriaId);

        return IngredientDefaultResponse.fromEntities(ingredients);
    }
}
