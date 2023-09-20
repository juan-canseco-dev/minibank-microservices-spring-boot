package com.jcanseco.dev.bank.minibank.accountsservice.mappers;

import com.jcanseco.dev.bank.minibank.accountsservice.dtos.AccountDto;
import com.jcanseco.dev.bank.minibank.accountsservice.models.Account;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountMapper {
    AccountDto accountToAccountDto(Account account);
}
