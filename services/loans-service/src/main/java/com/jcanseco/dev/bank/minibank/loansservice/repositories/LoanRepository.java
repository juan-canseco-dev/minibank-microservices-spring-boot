package com.jcanseco.dev.bank.minibank.loansservice.repositories;

import com.jcanseco.dev.bank.minibank.loansservice.models.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {
    List<Loan> findAllByCustomerIdOrderByStartDateDesc(int customerId);
}
