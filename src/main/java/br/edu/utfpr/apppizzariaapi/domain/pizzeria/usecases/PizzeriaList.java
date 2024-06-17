package br.edu.utfpr.apppizzariaapi.domain.pizzeria.usecases;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaListResponse;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzeriaRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaListResponse.fromEntities;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PizzeriaList {

    private final PizzeriaRepository pizzeriaRepository;

    public List<PizzeriaListResponse> list(String nome) {
        if (StringUtils.isNotBlank(nome)) {
            return fromEntities(pizzeriaRepository.findAllByNameLikeIgnoreCase("%" + nome.toUpperCase() + "%"));
        }

        return fromEntities(pizzeriaRepository.findAll());
    }
}
