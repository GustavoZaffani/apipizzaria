package br.edu.utfpr.apppizzariaapi.infra.controller.interceptor;

import br.edu.utfpr.apppizzariaapi.infra.cache.AuthenticationContext;
import br.edu.utfpr.apppizzariaapi.infra.exceptions.AuthenticationApiException;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzeriaRepository;
import br.edu.utfpr.apppizzariaapi.infra.translation.TranslationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;
import java.util.UUID;

import static br.edu.utfpr.apppizzariaapi.infra.translation.constants.TranslationConstants.AUTH_NO_HEADER_PRESENT;
import static br.edu.utfpr.apppizzariaapi.infra.translation.constants.TranslationConstants.AUTH_PIZZERIA_INFORMED_NOT_FOUND;
import static io.micrometer.common.util.StringUtils.isBlank;

@Component
@RequiredArgsConstructor
public class HeaderInterceptor implements HandlerInterceptor {
    private static final List<String> ACCEPT_URL_NO_HEADER = List.of(
            "/v1/pizzerias/login",
            "/v1/pizzerias"
    );

    private final TranslationService translationService;
    private final PizzeriaRepository pizzeriaRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String headerValue = request.getHeader("PizzeriaId");

        if (isBlank(headerValue)) {
            if (!ACCEPT_URL_NO_HEADER.contains(request.getRequestURI())) {
                throw new AuthenticationApiException(translationService.getMessage(AUTH_NO_HEADER_PRESENT));
            }
        } else {
            UUID pizzeriaId = UUID.fromString(headerValue);

            pizzeriaRepository.findById(pizzeriaId)
                    .orElseThrow(() -> new AuthenticationApiException(translationService.getMessage(AUTH_PIZZERIA_INFORMED_NOT_FOUND)));

            AuthenticationContext.setPizzeriaId(pizzeriaId);
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        AuthenticationContext.clear();
    }
}
