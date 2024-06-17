package br.edu.utfpr.apppizzariaapi.domain.pizzeria.usecases;

import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzeriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PizzeriaDelete {

    private final PizzeriaRepository pizzeriaRepository;

    public void delete(UUID id) {
        if (!pizzeriaRepository.existsById(id)) {
            throw new RuntimeException("Pizzeria not found");
        }

        pizzeriaRepository.deleteById(id);
    }
}
