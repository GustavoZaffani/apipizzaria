package br.edu.utfpr.apppizzariaapi.domain.pizza.usecases;

import br.edu.utfpr.apppizzariaapi.infra.exceptions.RegisterNotFoundException;
import br.edu.utfpr.apppizzariaapi.infra.pizza.repositories.PizzaRepository;
import br.edu.utfpr.apppizzariaapi.infra.translation.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static br.edu.utfpr.apppizzariaapi.infra.translation.constants.TranslationConstants.PIZZA_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class PizzaDelete {

    private final PizzaRepository pizzaRepository;
    private final TranslationService translationService;

    public void delete(UUID id) {
        if (!pizzaRepository.existsById(id)) {
            throw new RegisterNotFoundException(translationService.getMessage(PIZZA_NOT_FOUND));
        }

        pizzaRepository.delete(id);
    }
}
