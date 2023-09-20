package com.jcanseco.dev.bank.minibank.accountsservice.controllers;

import com.jcanseco.dev.bank.minibank.accountsservice.dtos.AccountDetailsDto;
import com.jcanseco.dev.bank.minibank.accountsservice.dtos.AccountDto;
import com.jcanseco.dev.bank.minibank.accountsservice.services.AccountService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
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
    @CircuitBreaker(name="accountDetailsSupport", fallbackMethod = "getAccountDetailsFallback")
    @Retry(name= "retryForAccountDetails", fallbackMethod = "getAccountDetailsFallback")
    public ResponseEntity<AccountDetailsDto> getAccountDetails(@PathVariable int customerId) {
        return ResponseEntity.ok(service.getAccountDetails(customerId));
    }

    private ResponseEntity<AccountDetailsDto> getAccountDetailsFallback(int customerId, Throwable t) {
        log.error("Retry get account details", t);
        var response = service.getAccountDetails(customerId);
        log.info("Account details with the id {} is successful", customerId);
        return ResponseEntity.ok(response);
    }
}
