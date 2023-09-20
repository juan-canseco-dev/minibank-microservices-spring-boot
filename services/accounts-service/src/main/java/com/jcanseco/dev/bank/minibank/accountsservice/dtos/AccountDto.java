package com.jcanseco.dev.bank.minibank.accountsservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private long id;
    private CustomerDto customer;
    private String accountType;
    private String branchAddress;
    private LocalDate createdAt;
}
