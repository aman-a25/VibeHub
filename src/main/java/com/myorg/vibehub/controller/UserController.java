package com.myorg.vibehub.controller;

import com.myorg.vibehub.dto.request.UserRequestDto;
import com.myorg.vibehub.dto.response.GenericResponseDto;
import com.myorg.vibehub.dto.response.UserResponseDto;
import com.myorg.vibehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserRequestDto userRequestDto) {

        return new ResponseEntity<>(userService.addUser(userRequestDto),HttpStatusCode.valueOf(201));

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id),HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRequestDto userRequestDto , @PathVariable Long id) {
        return new ResponseEntity<>(userService.updateUser(id , userRequestDto),HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<GenericResponseDto> deleteUser(@RequestParam Long id) {
        return new ResponseEntity<>(userService.removeUserById(id), HttpStatusCode.valueOf(200));
    }

}