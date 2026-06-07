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

    private String countryName;
    private String countryCode;
    private String shortName;
}
