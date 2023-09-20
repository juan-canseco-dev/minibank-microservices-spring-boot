package com.jcanseco.dev.bank.minibank.accountsservice.repositories;

import com.jcanseco.dev.bank.minibank.accountsservice.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findAccountByCustomerId(int customerId);
}
