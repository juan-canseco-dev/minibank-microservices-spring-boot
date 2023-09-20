package com.jcanseco.dev.bank.minibank.accountsservice.dtos;

import com.jcanseco.dev.bank.minibank.accountsservice.models.Card;
import com.jcanseco.dev.bank.minibank.accountsservice.models.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetailsDto {
    private AccountDto account;
    private List<Loan> loans;
    private List<Card> cards;
}
