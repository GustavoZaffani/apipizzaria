package br.edu.utfpr.apppizzariaapi.infra.pizzeria.repositories;

import br.edu.utfpr.apppizzariaapi.domain.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
