package com.myorg.vibehub.service;

import com.myorg.vibehub.dto.request.PostRequestDto;
import com.myorg.vibehub.dto.response.GenericResponseDto;
import com.myorg.vibehub.dto.response.PostResponseDto;
import com.myorg.vibehub.model.Post;
import com.myorg.vibehub.repository.PostRepository;
import com.myorg.vibehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostServiceImplement implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PostResponseDto addPost(PostRequestDto postRequestDto) {

        Post post = mapPostRequestDtoToPost(postRequestDto);

        post.setShareCount(0L);
        post.setLikeCount(0L);
        post.setCommentCount(0L);

        postRepository.save(post);

        return (mapPostToPostResponseDto(post));
    }

    @Override
    public PostResponseDto updatePost(Long id ,PostRequestDto postRequestDto) {

        Post post = mapPostRequestDtoToPost(postRequestDto);
        post.setId(id);
        postRepository.save(post);
        return (mapPostToPostResponseDto(post));

    }

    @Override
    public GenericResponseDto deletePostById(Long id) {
        postRepository.deleteById(id);
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        genericResponseDto.setMessage("Post has been deleted");
        genericResponseDto.setSuccess(true);
        return genericResponseDto;
    }

    @Override
    public PostResponseDto getPostById(Long id) {
        return (mapPostToPostResponseDto( postRepository.getReferenceById(id)));

    }

    @Override
    public List<PostResponseDto> getAllPosts() {

       List<Post> posts = postRepository.findAll();
       List<PostResponseDto> postResponseDtoList = new ArrayList<>();

       for (Post post : posts) {
           PostResponseDto postResponseDto = mapPostToPostResponseDto(post);
           postResponseDtoList.add(postResponseDto);
       }
       return postResponseDtoList;

    }

    @Override
    public List<PostResponseDto> getAllPostsByUser(Long id) {


        List<Post> posts = postRepository.findByUser(userRepository.getReferenceById(id));
        List<PostResponseDto> postResponseDtoList = new LinkedList<>();

        for (Post post : posts) {
            PostResponseDto postResponseDto = mapPostToPostResponseDto(post);
            postResponseDtoList.add(postResponseDto);
        }
        return postResponseDtoList;
    }

    //Helper methods
    private PostResponseDto mapPostToPostResponseDto(Post post) {
        PostResponseDto postResponseDto = new PostResponseDto();

        postResponseDto.setId(post.getId());
        postResponseDto.setUser(post.getUser());
        postResponseDto.setCaption(post.getCaption());
        postResponseDto.setCommentCount(post.getCommentCount());
        postResponseDto.setLikeCount(post.getLikeCount());
        postResponseDto.setShareCount(post.getShareCount());

        return postResponseDto;
    }

    private Post mapPostRequestDtoToPost(PostRequestDto postRequestDto) {
        Post post = new Post();
        post.setCaption(postRequestDto.getCaption());
        post.setUser(userRepository.getReferenceById( postRequestDto.getUserId()));
        post.setUrl(postRequestDto.getUrl());

        return post;
    }
}
