package br.edu.utfpr.apppizzariaapi.domain.pizza.entities;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.entities.Ingredient;
import br.edu.utfpr.apppizzariaapi.domain.pizza.enumerations.SizePizza;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "pizza")
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
}
