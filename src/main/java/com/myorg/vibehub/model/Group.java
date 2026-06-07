package com.myorg.vibehub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
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

    @ManyToMany(mappedBy = "groupss" )
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnore
    private List<User> users;
}
