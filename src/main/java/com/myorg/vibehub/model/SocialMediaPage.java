package com.myorg.vibehub.model;

import com.myorg.vibehub.enums.PageCatagory;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
@Entity
@Table(name = "SOCIAL_MEDIA_PAGE")
public class SocialMediaPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private PageCatagory pageCatagory;
    private String Description;
    private Instant createdDate;
    private String password;

}
