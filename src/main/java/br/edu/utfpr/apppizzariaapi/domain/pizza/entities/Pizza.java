package br.edu.utfpr.apppizzariaapi.domain.pizza.entities;

import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.pizza.requests.PizzaUpdateRequest;
import br.edu.utfpr.apppizzariaapi.infra.cache.AuthenticationContext;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static io.micrometer.common.util.StringUtils.isNotBlank;

@Getter
@Entity
@Table(name = "pizza")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Where(clause = "active = true")
public class Pizza {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private UUID pizzeriaId;

    private String name;

    private BigDecimal price;

    private boolean active;

    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL)
    private List<PizzaIngredient> ingredients;

    public Pizza(PizzaCreateRequest request) {
        this.pizzeriaId = AuthenticationContext.getPizzeriaId();
        this.name = request.name();
        this.price = request.price();
        this.active = true;
        this.ingredients = request.ingredients()
                .stream()
                .map(ingredient -> new PizzaIngredient(this, ingredient))
                .toList();
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
