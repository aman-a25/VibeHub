package com.myorg.vibehub.dto.request;

import com.myorg.vibehub.model.User;
import lombok.Data;

@Data
public class PostRequestDto {

    private String Caption ;
    private Long UserId;
    private String url;

}
