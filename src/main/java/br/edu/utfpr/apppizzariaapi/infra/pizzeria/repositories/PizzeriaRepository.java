package br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories;

import br.edu.utfpr.apppizzariaapi.domain.pizzeria.entities.Pizzeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PizzeriaRepository extends JpaRepository<Pizzeria, UUID> {

    List<Pizzeria> findAllByNameLikeIgnoreCase(String name);

    boolean existsByLogin(String login);

    Optional<Pizzeria> findByLogin(String login);

    @Modifying
    @Query("update Pizzeria p set p.active = false where p.id = :id") // TODO
    void delete(@Param("id") UUID id);
}
