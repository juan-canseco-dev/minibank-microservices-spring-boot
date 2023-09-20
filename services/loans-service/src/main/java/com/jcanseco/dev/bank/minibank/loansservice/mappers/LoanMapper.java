package com.jcanseco.dev.bank.minibank.loansservice.mappers;
import com.jcanseco.dev.bank.minibank.loansservice.dtos.LoanDto;
import com.jcanseco.dev.bank.minibank.loansservice.models.Loan;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LoanMapper {
    LoanDto loanToLoanDto(Loan loan);
}
