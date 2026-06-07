package com.myorg.vibehub.dto.request;

import lombok.Data;

@Data
public class PostRequestDto {

    private String caption ;
    private Long userId;
    private String url;

}
