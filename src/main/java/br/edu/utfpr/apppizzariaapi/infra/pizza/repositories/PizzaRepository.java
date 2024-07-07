package br.edu.utfpr.apppizzariaapi.infra.pizza.repositories;

import br.edu.utfpr.apppizzariaapi.domain.pizza.entities.Pizza;
import br.edu.utfpr.apppizzariaapi.domain.sale.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PizzaRepository extends JpaRepository<Pizza, UUID> {

    @Modifying
    @Query("update Pizza p " +
            "set p.active = false, p.deletedAt = current timestamp " +
            "where p.id = :id")
    void delete(UUID id);

    List<Pizza> findAllByPizzeriaId(UUID pizzeriaId);
}
