package com.myorg.vibehub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myorg.vibehub.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "profile_pictures")
public class ProfilePicture {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    // Although usually database is capable of storing Images by itself
    // but that is a very inefficient method
    // Because it makes database huge(and databse is expensive then normal storage) While increasing the load on database also
    // hence we are going to upload to a CDL server or storage and in database we store its address

    // but for now we are going to store image directly

    private String url;
    private String alternativeText;

    @OneToOne
    @JsonIgnore
    private User user;
}
