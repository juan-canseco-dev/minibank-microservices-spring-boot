package com.jcanseco.dev.bank.minibank.cardservice.controllers;

import com.jcanseco.dev.bank.minibank.cardservice.dtos.CardDto;
import com.jcanseco.dev.bank.minibank.cardservice.services.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CardController {
    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }

    @GetMapping("/{customerId}/customer")
    public ResponseEntity<List<CardDto>> getCardsByCustomer(@RequestHeader("correlation-id") String correlationId, @PathVariable Long customerId) {
        return ResponseEntity.ok(service.getCardsByCustomer(customerId));
    }
}
