package br.edu.utfpr.apppizzariaapi.infra.ingredient.repositories;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {

    List<Ingredient> findAllByPizzeriaId(UUID pizzeriaId);
}
