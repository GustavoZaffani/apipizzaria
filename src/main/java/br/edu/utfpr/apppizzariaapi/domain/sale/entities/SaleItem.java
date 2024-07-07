package br.edu.utfpr.apppizzariaapi.domain.sale.entities;

import br.edu.utfpr.apppizzariaapi.domain.pizza.entities.Pizza;
import br.edu.utfpr.apppizzariaapi.infra.cache.AuthenticationContext;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "sale_item")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class SaleItem {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private UUID pizzeriaId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pizza pizza;

    private Long quantity;

    public SaleItem(Sale sale, Pizza pizza, Long quantity) {
        this.pizzeriaId = AuthenticationContext.getPizzeriaId();
        this.sale = sale;
        this.pizza = pizza;
        this.quantity = quantity;
    }
}
