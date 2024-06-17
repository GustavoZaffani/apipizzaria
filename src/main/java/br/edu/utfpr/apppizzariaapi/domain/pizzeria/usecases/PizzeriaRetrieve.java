package br.edu.utfpr.apppizzariaapi.domain.pizzeria.usecases;

import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzeriaRepository;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaRetrieveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PizzeriaRetrieve {

    private final PizzeriaRepository pizzeriaRepository;

    public PizzeriaRetrieveResponse retrieve(UUID id) {
        return pizzeriaRepository.findById(id)
                .map(PizzeriaRetrieveResponse::fromEntity)
                .orElseThrow(() -> new RuntimeException("Pizzeria not found"));
    }
}
