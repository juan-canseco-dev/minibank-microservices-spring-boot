package com.jcanseco.dev.bank.minibank.cardservice.services;

import com.jcanseco.dev.bank.minibank.cardservice.dtos.CardDto;
import com.jcanseco.dev.bank.minibank.cardservice.mappers.CardMapper;
import com.jcanseco.dev.bank.minibank.cardservice.repositories.CardRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CardServiceImpl implements CardService{
    private final CardRepository repository;
    private final CardMapper mapper;

    public CardServiceImpl(CardRepository repository, CardMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CardDto> getCardsByCustomer(Long customerId) {
        return repository
                .findAllByCustomerId(customerId.intValue())
                .stream()
                .map(mapper::cardToCardDto)
                .toList();
    }
}
