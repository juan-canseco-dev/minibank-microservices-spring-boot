package com.jcanseco.dev.bank.minibank.accountsservice.controllers;

import com.jcanseco.dev.bank.minibank.accountsservice.dtos.AccountDetailsDto;
import com.jcanseco.dev.bank.minibank.accountsservice.dtos.AccountDto;
import com.jcanseco.dev.bank.minibank.accountsservice.services.AccountService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/{customerId}")
    @Timed(value = "getAccount.time", description = "Time taken to return Account")
    public ResponseEntity<AccountDto> getAccount(@PathVariable int customerId) {
        log.info("getAccount with id {} starts", customerId);
        var account = service.getAccount(customerId);
        log.info("getAccount with id {} starts", customerId);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{customerId}/details")
    @CircuitBreaker(name="accountDetailsSupport", fallbackMethod = "getAccountDetailsFallback")
    @Retry(name= "retryForAccountDetails", fallbackMethod = "getAccountDetailsFallback")
    @Timed(value = "getAccountDetails.time", description = "Time taken to return Account Details")
    public ResponseEntity<AccountDetailsDto> getAccountDetails(@RequestHeader("correlation-id") String correlationId, @PathVariable int customerId) {
        log.info("getAccountDetails with id {} starts", customerId);
        var accountDetails = service.getAccountDetails(correlationId, customerId);
        log.info("getAccount details with id {} ends", customerId);
        return ResponseEntity.ok(accountDetails);
    }

    private ResponseEntity<AccountDetailsDto> getAccountDetailsFallback(@RequestHeader("correlation-id") String correlationId, int customerId, Throwable t) {
        log.error("Retry get account details", t);
        var response = service.getAccountDetails(correlationId, customerId);
        log.info("Account details with the id {} is successful", customerId);
        return ResponseEntity.ok(response);
    }
}
