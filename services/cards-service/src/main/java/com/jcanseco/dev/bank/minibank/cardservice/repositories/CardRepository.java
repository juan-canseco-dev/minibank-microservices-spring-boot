package com.jcanseco.dev.bank.minibank.cardservice.repositories;

import com.jcanseco.dev.bank.minibank.cardservice.models.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CardRepository  extends CrudRepository<Card, Long> {
    List<Card> findAllByCustomerId(int customerId);
}
