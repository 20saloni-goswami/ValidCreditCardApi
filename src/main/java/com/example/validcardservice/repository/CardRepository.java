package com.example.validcardservice.repository;

import com.example.validcardservice.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
