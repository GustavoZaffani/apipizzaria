package br.edu.utfpr.apppizzariaapi.application.controllers.sale;

import br.edu.utfpr.apppizzariaapi.domain.sale.requests.SaleCreateRequest;
import br.edu.utfpr.apppizzariaapi.domain.sale.responses.SaleDefaultResponse;
import br.edu.utfpr.apppizzariaapi.domain.sale.usecases.SaleCreate;
import br.edu.utfpr.apppizzariaapi.domain.sale.usecases.SaleList;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sales")
public class SaleController {

    private final SaleCreate saleCreate;
    private final SaleList saleList;

    @PostMapping
    public ResponseEntity<SaleDefaultResponse> create(@Valid @RequestBody SaleCreateRequest request) {
        return ResponseEntity.ok(saleCreate.create(request));
    }

    @GetMapping
    public ResponseEntity<List<SaleDefaultResponse>> findAll() {
        return ResponseEntity.ok(saleList.list());
    }
}
