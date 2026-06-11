package com.myorg.vibehub.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true , nullable = false)
    private String countryName;
    @Column(unique = true , nullable = false)
    private String slugName;
    @Column(nullable = false)
    private String countryTelephoneCode;

}
