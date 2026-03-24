package com.myorg.vibehub.model;

import com.myorg.vibehub.enums.PageCatagory;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class SocialMediaPage {

    private Long id;
    private String name;
    private PageCatagory pageCatagory;
    private String Description;
    private Instant createdDate;
    private String password;

}
