package br.edu.utfpr.apppizzariaapi.domain.pizza.usecases;

import br.edu.utfpr.apppizzariaapi.domain.pizza.entities.Pizza;
import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaUpdateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizza.responses.PizzaSaveResponse;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PizzaUpdate {

    private final PizzaRepository pizzaRepository;

    public PizzaSaveResponse update(UUID pizzaId, PizzaUpdateRequest request) {
        Pizza pizza = pizzaRepository.findById(pizzaId).orElseThrow(() -> new RuntimeException("Pizza not found"));
        pizza.update(request);

        return PizzaSaveResponse.fromEntity(pizzaRepository.save(pizza));
    }
}
