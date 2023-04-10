package com.example.validcardservice.Service;

import com.example.validcardservice.entities.Card;
import com.example.validcardservice.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService{
    @Autowired
    private CardRepository repository;
    @Override
    public String validCard(Card card) {
        Optional<Card> dbCard = repository.findById(card.getId());
        Card dbCard1= dbCard.get();
        if(dbCard1.getCardNumber().equals(card.getCardNumber())
        && dbCard1.getCvv().equals(card.getCvv())
        && card.getExpiringDate().isAfter(LocalDate.now())
                && dbCard1.getExpiringDate().equals(card.getExpiringDate())){
            return "Valid";
        }
        return "Invalid";
    }
}
