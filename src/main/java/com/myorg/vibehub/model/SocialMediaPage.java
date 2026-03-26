package com.myorg.vibehub.model;

import com.myorg.vibehub.enums.PageCatagory;
import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;

@Data
@Entity
@Table(name = "social_media_page") //This is not needed here because the default conversion of hibernate is also the same
public class SocialMediaPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private PageCatagory pageCatagory;
    private String Description;
    private Instant createdDate;
    private String password;

}
