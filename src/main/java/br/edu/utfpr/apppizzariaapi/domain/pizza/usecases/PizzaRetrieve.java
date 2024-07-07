package br.edu.utfpr.apppizzariaapi.domain.pizza.usecases;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.responses.IngredientDefaultResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizza.responses.PizzaDefaultResponse;
import br.edu.utfpr.apppizzariaapi.infra.exceptions.RegisterNotFoundException;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.IngredientRepository;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzaRepository;
import br.edu.utfpr.apppizzariaapi.infra.translation.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static br.edu.utfpr.apppizzariaapi.domain.ingredient.constants.TranslationConstants.INGREDIENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PizzaRetrieve {

    private final PizzaRepository pizzaRepository;
    private final TranslationService translationService;

    public PizzaDefaultResponse retrieve(UUID id) {
        return pizzaRepository.findById(id)
                .map(PizzaDefaultResponse::fromEntity)
                .orElseThrow(() -> new RegisterNotFoundException(translationService.getMessage(INGREDIENT_NOT_FOUND)));
    }
}
