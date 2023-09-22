package com.jcanseco.dev.bank.minibank.accountsservice.services;

import com.jcanseco.dev.bank.minibank.accountsservice.dtos.AccountDto;
import com.jcanseco.dev.bank.minibank.accountsservice.dtos.AccountDetailsDto;

public interface AccountService {
    AccountDto getAccount(int customerId);
    AccountDetailsDto getAccountDetails(String correlationId, int customerId);
}
