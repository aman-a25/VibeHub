package com.myorg.vibehub.controller;

import com.myorg.vibehub.dto.request.PostRequestDto;
import com.myorg.vibehub.dto.response.GenericResponseDto;
import com.myorg.vibehub.dto.response.PostResponseDto;
import com.myorg.vibehub.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping()
    public ResponseEntity<PostResponseDto> addPost(@RequestBody PostRequestDto postRequestDto){
        PostResponseDto postResponseDto = postService.addPost(postRequestDto);

        if (postResponseDto != null) {
            return new ResponseEntity<>(postResponseDto, HttpStatusCode.valueOf(201));
        }else  {
            return new ResponseEntity<>(HttpStatus.valueOf(400));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable Long id , @RequestBody PostRequestDto postRequestDto){
        PostResponseDto postResponseDto = postService.updatePost(id , postRequestDto);

        return new ResponseEntity<>(postResponseDto, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponseDto> deletePost(@PathVariable Long id){

        GenericResponseDto response = postService.deletePostById(id);

        if (response.getSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable Long id){

        PostResponseDto postResponseDto = postService.getPostById(id);

        if (postResponseDto != null) {
            return new ResponseEntity<>(postResponseDto, HttpStatusCode.valueOf(200));
        }
            return new ResponseEntity<>(HttpStatus.valueOf(404));

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<PostResponseDto>> getPostByUserId(@PathVariable Long id){

        List<PostResponseDto> postResponseDtoList = postService.getAllPostsByUser(id);

        return new ResponseEntity<>(postResponseDtoList, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PostResponseDto>> getAllPosts(){
        List<PostResponseDto> postResponseDtoList = postService.getAllPosts();
        return new ResponseEntity<>(postResponseDtoList, HttpStatus.OK);
    }

}
