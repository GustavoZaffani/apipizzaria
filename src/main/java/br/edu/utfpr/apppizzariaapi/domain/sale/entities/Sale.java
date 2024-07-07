package br.edu.utfpr.apppizzariaapi.domain.sale.entities;

import br.edu.utfpr.apppizzariaapi.domain.pizza.entities.Pizza;
import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Pizzeria;
import br.edu.utfpr.apppizzariaapi.domain.sale.requests.SaleCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.sale.requests.SaleItemCreateRequest;
import br.edu.utfpr.apppizzariaapi.infra.cache.AuthenticationContext;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Entity
@Table(name = "sale")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private UUID pizzeriaId;

    @OneToMany(mappedBy = "sale", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SaleItem> saleItems;

    private LocalDateTime saleDate;

    private BigDecimal total = BigDecimal.ZERO;

    public Sale(SaleCreateRequest saleCreateRequest, Map<UUID, Pizza> pizzaMap) {
        this.pizzeriaId = AuthenticationContext.getPizzeriaId();
        this.saleDate = LocalDateTime.now();
        this.saleItems = saleCreateRequest.saleItems().stream()
                .map(saleItem -> {
                    Pizza pizza = pizzaMap.get(saleItem.pizzaId());
                    this.total = this.total.add(pizza.getPrice().multiply(BigDecimal.valueOf(saleItem.quantity())));
                    return new SaleItem(this, pizza, saleItem.quantity());
                }).toList();
    }
}
