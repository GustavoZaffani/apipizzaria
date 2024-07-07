package br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Pizzeria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PizzeriaRepository extends JpaRepository<Pizzeria, UUID> {

    List<Pizzeria> findAllByNameLikeIgnoreCase(String name);

    boolean existsByLogin(String login);

    Optional<Pizzeria> findByLogin(String login);
}
