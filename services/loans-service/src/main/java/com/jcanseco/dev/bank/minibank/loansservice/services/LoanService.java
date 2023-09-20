package com.jcanseco.dev.bank.minibank.loansservice.services;

import com.jcanseco.dev.bank.minibank.loansservice.dtos.LoanDto;

import java.util.List;

public interface LoanService {
    List<LoanDto> getLoansByCustomer(int customerId);
}
