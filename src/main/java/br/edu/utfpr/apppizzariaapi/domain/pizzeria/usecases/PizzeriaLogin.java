package br.edu.utfpr.apppizzariaapi.domain.pizzeria.usecases;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Pizzeria;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaLoginRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaLoginResponse;
import br.edu.utfpr.apppizzariaapi.infra.exceptions.AuthenticationApiException;
import br.edu.utfpr.apppizzariaapi.infra.exceptions.BadRequestException;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzeriaRepository;
import br.edu.utfpr.apppizzariaapi.infra.translation.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.edu.utfpr.apppizzariaapi.infra.translation.constants.TranslationConstants.AUTH_LOGIN_NOT_FOUND;
import static br.edu.utfpr.apppizzariaapi.infra.translation.constants.TranslationConstants.AUTH_PASSWORD_INVALID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PizzeriaLogin {

    private final PizzeriaRepository pizzeriaRepository;
    private final TranslationService translationService;

    public PizzeriaLoginResponse login(PizzeriaLoginRequest request) {
        Pizzeria pizzeria = pizzeriaRepository.findByLogin(request.login())
                .orElseThrow(() -> new AuthenticationApiException(translationService.getMessage(AUTH_LOGIN_NOT_FOUND)));

        if (!pizzeria.getPassword().equals(request.password())) {
            throw new AuthenticationApiException(translationService.getMessage(AUTH_PASSWORD_INVALID));
        }

        return PizzeriaLoginResponse.fromEntity(pizzeria);
    }
}
