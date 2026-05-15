package com.myorg.vibehub.controller;

import com.myorg.vibehub.dto.request.UserRequestDto;
import com.myorg.vibehub.dto.response.GenericResponseDto;
import com.myorg.vibehub.dto.response.UserResponseDto;
import com.myorg.vibehub.enums.Gender;
import com.myorg.vibehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.HttpStatus;
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

        UserResponseDto userResponseDto = userService.addUser(userRequestDto);

        if (userResponseDto != null) {
            return new ResponseEntity<>(userResponseDto, HttpStatusCode.valueOf(201));
        }else{
            return new ResponseEntity<>(HttpStatus.valueOf(400));
        }

    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        UserResponseDto response = userService.getUserById(id);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
        }else {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
    }

    @GetMapping("/search/username/{userName}")
    public ResponseEntity<UserResponseDto> getUserByUserName(@PathVariable String userName) {
        UserResponseDto response = userService.getUserByUsername(userName);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
        }else {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
    }

    @GetMapping("/search/name/{Name}")
    public ResponseEntity<List<UserResponseDto>> getUserByName(@PathVariable String Name) {
        return new ResponseEntity<>(userService.getUserByName(Name), HttpStatusCode.valueOf(200));
    }


    @GetMapping("/search/nameandgender")
    public ResponseEntity<List<UserResponseDto>> getUserByNameAndGender(@RequestParam String name , @RequestParam Gender gender) {
        return new ResponseEntity<>(userService.getUserByNameAndGender(name , gender), HttpStatusCode.valueOf(200));
    }



    @GetMapping("/search")
    public ResponseEntity<List<UserResponseDto>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/search/email/domain/{domain}")
    public ResponseEntity<List<UserResponseDto>> getUserByEmail(@PathVariable String domain) {
        return new ResponseEntity<>(userService.getUserWithGmailEmail(domain), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRequestDto userRequestDto , @PathVariable Long id) {

        UserResponseDto response = userService.updateUser(id , userRequestDto);

        if (response != null) {
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));

        }else  {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
    }

    @DeleteMapping
    public ResponseEntity<GenericResponseDto> deleteUser(@RequestParam Long id) {

        GenericResponseDto response = userService.removeUserById(id);

        if (response.getSuccess()) {
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
        }else  {
            return new ResponseEntity<>(response, HttpStatus.valueOf(404));
        }
    }

}