package com.example.rewards.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="reward")
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "customer-id")
    private String customerId;

    @Column(name = "card-number")
    private String cardNumber;

}
