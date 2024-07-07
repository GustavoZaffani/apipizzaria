package br.edu.utfpr.apppizzariaapi.domain.pizzeria.validators;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaCreateRequest;
import br.edu.utfpr.apppizzariaapi.infra.exceptions.BadRequestException;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzeriaRepository;
import br.edu.utfpr.apppizzariaapi.infra.translation.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static br.edu.utfpr.apppizzariaapi.infra.translation.constants.TranslationConstants.PIZZERIA_LOGIN_EXISTS;

@Component
@RequiredArgsConstructor
public class PizzeriaValidator {

    private final PizzeriaRepository pizzeriaRepository;
    private final TranslationService translationService;

    @Transactional(readOnly = true)
    public void validate(PizzeriaCreateRequest request) {
        if (pizzeriaRepository.existsByLogin(request.login())) {
            throw new BadRequestException(translationService.getMessage(PIZZERIA_LOGIN_EXISTS));
        }
    }
}
