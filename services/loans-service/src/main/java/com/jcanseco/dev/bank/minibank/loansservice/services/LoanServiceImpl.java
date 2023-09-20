package com.jcanseco.dev.bank.minibank.loansservice.services;

import com.jcanseco.dev.bank.minibank.loansservice.dtos.LoanDto;
import com.jcanseco.dev.bank.minibank.loansservice.mappers.LoanMapper;
import com.jcanseco.dev.bank.minibank.loansservice.repositories.LoanRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository repository;
    private final LoanMapper mapper;

    public LoanServiceImpl(LoanRepository repository, LoanMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<LoanDto> getLoansByCustomer(int customerId) {
        return repository
                .findAllByCustomerIdOrderByStartDateDesc(customerId)
                .stream()
                .map(mapper::loanToLoanDto)
                .toList();
    }
}
