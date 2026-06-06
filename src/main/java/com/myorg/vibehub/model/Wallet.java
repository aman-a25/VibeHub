package com.myorg.vibehub.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double balance;

    @OneToOne
    private User user;

}
