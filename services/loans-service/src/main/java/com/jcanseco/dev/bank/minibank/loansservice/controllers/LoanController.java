package com.jcanseco.dev.bank.minibank.loansservice.controllers;

import com.jcanseco.dev.bank.minibank.loansservice.dtos.LoanDto;
import com.jcanseco.dev.bank.minibank.loansservice.services.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LoanController {
    private final LoanService service;
    public LoanController(LoanService service) {
        this.service = service;
    }

    @GetMapping("/{customerId}/customer")
    public ResponseEntity<List<LoanDto>> getLoansByCustomer(@RequestHeader("correlation-id") String correlationId, @PathVariable int customerId) {
        return ResponseEntity.ok(service.getLoansByCustomer(customerId));
    }
}
