package br.edu.utfpr.apppizzariaapi.domain.sale.usecases;

import br.edu.utfpr.apppizzariaapi.domain.sale.responses.SaleDefaultResponse;
import br.edu.utfpr.apppizzariaapi.infra.cache.AuthenticationContext;
import br.edu.utfpr.apppizzariaapi.infra.sale.repositories.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaleList {

    private final SaleRepository saleRepository;

    public List<SaleDefaultResponse> list() {
        return saleRepository.findAllByPizzeriaId(AuthenticationContext.getPizzeriaId()).stream()
                .map(SaleDefaultResponse::fromEntity)
                .toList();
    }
}
