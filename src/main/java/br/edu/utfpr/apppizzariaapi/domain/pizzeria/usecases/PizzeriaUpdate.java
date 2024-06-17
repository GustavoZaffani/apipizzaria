package br.edu.utfpr.apppizzariaapi.domain.pizzeria.usecases;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Pizzeria;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzeriaRepository;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaUpdateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PizzeriaUpdate {

    private final PizzeriaRepository pizzeriaRepository;

    public PizzeriaSaveResponse update(UUID id, PizzeriaUpdateRequest request) {
        Pizzeria pizzeria = pizzeriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pizzeria not found"));
        pizzeria.update(request);

        return PizzeriaSaveResponse.fromEntity(pizzeriaRepository.save(pizzeria));
    }
}
