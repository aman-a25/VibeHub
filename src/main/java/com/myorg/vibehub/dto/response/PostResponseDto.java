package com.myorg.vibehub.dto.response;

import lombok.Data;

@Data
public class PostResponseDto {
    private Long id;
    private String Caption ;
    private Long LikeCount;
    private Long CommentCount;
    private Long ShareCount;
    private Long userId;
    private String url;
}
