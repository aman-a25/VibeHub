package com.myorg.vibehub.dto.response;

import com.myorg.vibehub.model.Post;
import com.myorg.vibehub.model.User;
import lombok.Data;

@Data
public class PostResponseDto {
    private Long id;
    private String Caption ;
    private Long LikeCount;
    private Long CommentCount;
    private Long ShareCount;
    private User user;
    private String url;
}
