package br.edu.utfpr.apppizzariaapi.domain.ingredient.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MeasurementUnit {

    KG("Quilograma"),
    UN("Unidade"),
    LT("Litro");

    private final String description;
}
