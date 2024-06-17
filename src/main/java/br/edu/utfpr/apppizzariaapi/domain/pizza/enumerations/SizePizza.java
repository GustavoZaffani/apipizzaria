package br.edu.utfpr.apppizzariaapi.domain.pizza.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SizePizza {

    SMALL("Pequena"),
    MEDIUM("Média"),
    BIG("Grande");

    private final String description;
}
