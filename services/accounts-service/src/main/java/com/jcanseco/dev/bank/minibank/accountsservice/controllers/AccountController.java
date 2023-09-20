package com.jcanseco.dev.bank.minibank.accountsservice.controllers;

import com.jcanseco.dev.bank.minibank.accountsservice.dtos.AccountDetailsDto;
import com.jcanseco.dev.bank.minibank.accountsservice.dtos.AccountDto;
import com.jcanseco.dev.bank.minibank.accountsservice.services.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable int customerId) {
        return ResponseEntity.ok(service.getAccount(customerId));
    }

    @GetMapping("/{customerId}/details")
    public ResponseEntity<AccountDetailsDto> getAccountDetails(@PathVariable int customerId) {
        return ResponseEntity.ok(service.getAccountDetails(customerId));
    }
}
