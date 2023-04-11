package com.example.validcardservice.Controller;

import com.example.validcardservice.Service.CardService;
import com.example.validcardservice.entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @Autowired
    private CardService service;

    @PostMapping("/card")
    public String validCard(@RequestBody Card card){
        return service.validCard(card);
    }
}
