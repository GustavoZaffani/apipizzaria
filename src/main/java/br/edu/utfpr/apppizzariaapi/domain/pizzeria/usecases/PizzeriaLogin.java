package br.edu.utfpr.apppizzariaapi.domain.pizzeria.usecases;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Pizzeria;
import br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories.PizzeriaRepository;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.requests.PizzeriaLoginRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.responses.PizzeriaLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PizzeriaLogin {

    private final PizzeriaRepository pizzeriaRepository;

    public PizzeriaLoginResponse login(PizzeriaLoginRequest request) {
        Pizzeria pizzeria = pizzeriaRepository.findByLogin(request.login()).orElseThrow(() -> new RuntimeException("Login not found"));

        if (!pizzeria.getPassword().equals(request.password())) {
            throw new RuntimeException("Invalid password");
        }

        return PizzeriaLoginResponse.fromEntity(pizzeria);
    }
}
