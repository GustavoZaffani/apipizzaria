package br.edu.utfpr.apppizzariaapi.domain.pizza.entities;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.entities.Ingredient;
import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaIngredientCreateRequest;
import br.edu.utfpr.apppizzariaapi.infra.cache.AuthenticationContext;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Entity
@Table(name = "pizza_ingredient")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PizzaIngredient {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private UUID pizzeriaId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pizza pizza;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;

    private BigDecimal quantity;

    public PizzaIngredient(Pizza pizza, PizzaIngredientCreateRequest request) {
        this.pizzeriaId = AuthenticationContext.getPizzeriaId();
        this.ingredient = new Ingredient(request.ingredientId());
        this.pizza = pizza;
        this.quantity = request.quantity();
    }
}
