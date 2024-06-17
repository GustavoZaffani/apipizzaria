package br.edu.utfpr.apppizzariaapi.domain.pizzeria.usecases;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Pizzeria;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzeriaRepository;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaSaveResponse;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.validators.PizzeriaValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PizzeriaCreate {

    private final PizzeriaRepository pizzeriaRepository;
    private final PizzeriaValidator pizzeriaValidator;

    public PizzeriaSaveResponse create(PizzeriaCreateRequest request) {
        pizzeriaValidator.validate(request);

        Pizzeria pizzeria = new Pizzeria(request);
        return PizzeriaSaveResponse.fromEntity(pizzeriaRepository.save(pizzeria));
    }
}
