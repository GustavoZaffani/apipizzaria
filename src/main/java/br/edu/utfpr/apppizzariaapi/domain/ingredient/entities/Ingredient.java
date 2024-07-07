package br.edu.utfpr.apppizzariaapi.domain.ingredient.entities;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.enumerations.MeasurementUnit;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.requests.IngredientCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.ingredient.requests.IngredientUpdateRequest;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

import static io.micrometer.common.util.StringUtils.isNotBlank;

@Setter
@Getter
@Entity
@Table(name = "ingredient")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ingredient {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    private String description;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private MeasurementUnit measurementUnit;

    private BigDecimal quantity;

    public Ingredient(IngredientCreateRequest request) {
        this.name = request.name();
        this.description = request.description();
        this.price = request.price();
        this.measurementUnit = request.measurementUnit();
        this.quantity = request.quantity();
    }

    public Ingredient(UUID ingredientId) {
        this.id = ingredientId;
    }

    public void update(IngredientUpdateRequest request) {
        if (isNotBlank(request.name())) {
            this.name = request.name();
        }

        if (isNotBlank(request.description())) {
            this.description = request.description();
        }

        if (request.price() != null) {
            this.price = request.price();
        }
    }
}
