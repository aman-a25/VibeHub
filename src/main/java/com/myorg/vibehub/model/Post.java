Uh post package com.myorg.vibehub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String Caption ;
    private Long LikeCount;
    private Long CommentCount;
    private Long ShareCount;

    @ManyToOne
    @JsonIgnore
    private User user;
}
