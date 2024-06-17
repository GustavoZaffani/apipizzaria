package br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories;

import br.edu.utfpr.apppizzariaapi.domain.pizza.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PizzaRepository extends JpaRepository<Pizza, UUID>{
}
