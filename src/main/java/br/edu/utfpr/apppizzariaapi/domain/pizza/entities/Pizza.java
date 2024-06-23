package br.edu.utfpr.apppizzariaapi.domain.pizza.entities;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.entities.Ingredient;
import br.edu.utfpr.apppizzariaapi.domain.pizza.enumerations.SizePizza;
import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaUpdateRequest;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static io.micrometer.common.util.StringUtils.isNotBlank;

@Getter
@Entity
@Table(name = "pizza")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pizza {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private SizePizza size;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pizza_ingredients",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;

    public Pizza(PizzaCreateRequest request, List<Ingredient> ingredients) {
        this.name = request.name();
        this.price = request.price();
        this.size = request.size();
        this.ingredients = ingredients;
    }

    public void update(PizzaUpdateRequest request) {
        if (isNotBlank(request.name())) {
            this.name = request.name();
        }

        if (request.price() != null) {
            this.price = request.price();
        }
    }
}
