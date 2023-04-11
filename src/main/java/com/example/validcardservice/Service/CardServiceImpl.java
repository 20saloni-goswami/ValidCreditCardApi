package com.example.validcardservice.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.validcardservice.entities.Card;
import com.example.validcardservice.exception.IdNotFoundException;
import com.example.validcardservice.repository.CardRepository;
import org.apache.el.lang.ELArithmetic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository repository;

    @Override
    public String validCard(Card card) {
//        Optional<Card> dbCard = Optional.ofNullable(repository.findById(card.getId()).orElseThrow(()
//                -> new IdNotFoundException("  id not found !!")));
//        Optional<Card> dbCard = Optional.ofNullable(repository.findById(card.getId()).orElseThrow(() ->
//                new IdNotFoundException("ID NOT FOUND ON SERVER!!"+card.getId())));
//        System.out.println(dbCard);
        Optional<Card> dbCard = repository.findById(card.getId());
        if (dbCard.isPresent()) {
            Card dbCard1 = dbCard.get();
//        if(dbCard1.getCardNumber().equals(card.getCardNumber())
//        && dbCard1.getCvv().equals(card.getCvv())
//        && card.getExpiringDate().isBefore(dbCard1.getExpiringDate())
//                && card.getExpiringDate().isAfter(LocalDate.now())
//                || card.getExpiringDate().isEqual(LocalDate.now())
//                || dbCard1.getExpiringDate().equals(card.getExpiringDate())){
//            System.out.println(dbCard1);
//            return "Valid";
//        }
//        if(card.getId()==null){
//            return "Invalid";
//        }
            if (dbCard1.getCardNumber().equals(card.getCardNumber())) {
                if (dbCard1.getCvv().equals(card.getCvv())) {
                    if (card.getExpiringDate().isBefore(dbCard1.getExpiringDate())
                            && card.getExpiringDate().isAfter(LocalDate.now()) ||
                            card.getExpiringDate().isEqual(LocalDate.now())
                            || dbCard1.getExpiringDate().equals(card.getExpiringDate())
                    ) {
                        return "Valid";
                    }
                }

            }
            return "Invalid";
        }
        else{
            throw new IdNotFoundException("Id not found with ID: " +card.getId());
        }
    }
}
