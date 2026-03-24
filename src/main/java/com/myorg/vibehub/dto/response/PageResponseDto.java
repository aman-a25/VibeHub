package com.myorg.vibehub.dto.response;

import com.myorg.vibehub.enums.PageCatagory;
import lombok.Data;

import java.time.Instant;

@Data
public class PageResponseDto {

    private Long id;
    private String name;
    private PageCatagory pageCatagory;
    private String description;
    private Instant createdDate;
}
