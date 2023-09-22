package com.jcanseco.dev.bank.minibank.accountsservice.clients;

import com.jcanseco.dev.bank.minibank.accountsservice.models.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient("loans-service")
public interface LoansClient {
    @GetMapping("/{customerId}/customer")
    List<Loan> getCustomerLoans(@RequestHeader("correlation-id") String correlationId, @PathVariable int customerId);
}
