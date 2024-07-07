package br.edu.utfpr.apppizzariaapi.infra.sale.repositories;

import br.edu.utfpr.apppizzariaapi.domain.sale.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SaleRepository extends JpaRepository<Sale, UUID> {

    List<Sale> findAllByPizzeriaId(UUID pizzeriaId);
}
