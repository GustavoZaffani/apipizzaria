package br.edu.utfpr.apppizzariaapi.domain.pizza.usecases;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.responses.IngredientDefaultResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizza.responses.PizzaDefaultResponse;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.IngredientRepository;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PizzaList {

    private final PizzaRepository pizzaRepository;

    public List<PizzaDefaultResponse> list() {
        return PizzaDefaultResponse.fromEntities(pizzaRepository.findAll());
    }
}
