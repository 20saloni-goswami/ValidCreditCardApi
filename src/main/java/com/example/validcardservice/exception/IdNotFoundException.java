package com.example.validcardservice.exception;

import com.example.validcardservice.entities.Card;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String message) {
        super(message);
    }

    public IdNotFoundException(){
        super("ID NOT FOUND !!");
    }
}
