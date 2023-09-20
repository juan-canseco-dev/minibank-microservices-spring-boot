package com.jcanseco.dev.bank.minibank.cardservice.mappers;

import com.jcanseco.dev.bank.minibank.cardservice.dtos.CardDto;
import com.jcanseco.dev.bank.minibank.cardservice.models.Card;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CardMapper {
    CardDto cardToCardDto(Card card);
}
