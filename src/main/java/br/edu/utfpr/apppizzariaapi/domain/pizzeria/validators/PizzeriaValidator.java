package br.edu.utfpr.apppizzariaapi.domain.pizzeria.validators;

import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzeriaRepository;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PizzeriaValidator {

    private final PizzeriaRepository pizzeriaRepository;

    @Transactional(readOnly = true)
    public void validate(PizzeriaCreateRequest request) {
        validateLogin(request.login());
    }

    private void validateLogin(String login) {
        if (pizzeriaRepository.existsByLogin(login)) {
            throw new RuntimeException("Login already exists");
        }
    }

}
