package com.jcanseco.dev.bank.minibank.cardservice.services;

import com.jcanseco.dev.bank.minibank.cardservice.dtos.CardDto;
import java.util.List;

public interface CardService {
    List<CardDto> getCardsByCustomer(Long customerId);
}
