package br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories;

import br.edu.utfpr.apppizzariaapi.domain.ingredient.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {
}
