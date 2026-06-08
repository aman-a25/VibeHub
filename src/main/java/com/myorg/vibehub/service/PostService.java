package com.myorg.vibehub.service;

import com.myorg.vibehub.dto.request.PostRequestDto;
import com.myorg.vibehub.dto.response.GenericResponseDto;
import com.myorg.vibehub.dto.response.PostResponseDto;

import java.util.List;

public interface PostService {

    GenericResponseDto addPost(PostRequestDto postRequestDto);
    PostResponseDto updatePost(Long id ,PostRequestDto postRequestDto);
    GenericResponseDto deletePostById(Long id);
    PostResponseDto getPostById(Long id);
    List<PostResponseDto> getAllPosts();
    List<PostResponseDto> getAllPostsByUser(Long id);

}
