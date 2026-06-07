package com.myorg.vibehub.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String groupName;
    private String groupDescription;

    @OneToOne(mappedBy ="group",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private String groupProfilePic;
}
