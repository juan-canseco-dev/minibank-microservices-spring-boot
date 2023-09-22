package com.jcanseco.dev.bank.minibank.accountsservice.clients;

import com.jcanseco.dev.bank.minibank.accountsservice.models.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import java.util.List;

@FeignClient("cards-service")
public interface CardsClient {
    @GetMapping("/{customerId}/customer")
    List<Card> getCustomerCards(@RequestHeader("correlation-id") String correlationId, @PathVariable int customerId);
}
