package com.myorg.vibehub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private Long LikeCount = 0L;
    private Long CommentCount = 0L;
    private Long ShareCount = 0L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
