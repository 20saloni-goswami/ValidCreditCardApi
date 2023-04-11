package com.example.validcardservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "validcard")
public class Card {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "CARD_NUMBER")
    private String cardNumber;
    @Column(name = "CVV")
    private String cvv;
    @Column(name = "EXPIRING_DATE")
    private LocalDate expiringDate;
}
