package com.jcanseco.dev.bank.minibank.accountsservice.services;

import com.jcanseco.dev.bank.minibank.accountsservice.clients.CardsClient;
import com.jcanseco.dev.bank.minibank.accountsservice.clients.LoansClient;
import com.jcanseco.dev.bank.minibank.accountsservice.dtos.AccountDetailsDto;
import com.jcanseco.dev.bank.minibank.accountsservice.dtos.AccountDto;
import com.jcanseco.dev.bank.minibank.accountsservice.mappers.AccountMapper;
import com.jcanseco.dev.bank.minibank.accountsservice.repositories.AccountRepository;
import com.jcanseco.dev.bank.minibank.common.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private final CardsClient cardsClient;
    private final LoansClient loansClient;
    private final AccountMapper mapper;

    public AccountServiceImpl(
            AccountRepository repository,
            CardsClient cardsClient,
            LoansClient loansClient,
            AccountMapper mapper) {
        this.repository = repository;
        this.cardsClient = cardsClient;
        this.loansClient = loansClient;
        this.mapper = mapper;
    }

    @Override
    public AccountDto getAccount(int customerId) {
        return repository
                .findAccountByCustomerId(customerId)
                .map(mapper::accountToAccountDto)
                .orElseThrow(() -> new NotFoundException(String.format("The Account with the id: %d was not found.", customerId)));
    }

    @Override
    public AccountDetailsDto getAccountDetails(int customerId) {
        var account = repository
                .findAccountByCustomerId(customerId)
                .map(mapper::accountToAccountDto)
                .orElseThrow(() -> new NotFoundException(String.format("The Account with the id: %d was not found.", customerId)));
        var cards = cardsClient.getCustomerCards(customerId);
        var loans = loansClient.getCustomerLoans(customerId);
        return new AccountDetailsDto(account, loans, cards);
    }
}
