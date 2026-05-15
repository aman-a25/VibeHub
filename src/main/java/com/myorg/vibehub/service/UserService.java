package com.myorg.vibehub.service;

import com.myorg.vibehub.dto.request.UserRequestDto;
import com.myorg.vibehub.dto.response.GenericResponseDto;
import com.myorg.vibehub.dto.response.UserResponseDto;
import com.myorg.vibehub.enums.Gender;

import java.util.List;

public interface UserService {

    UserResponseDto addUser(UserRequestDto userRequestDto);
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> getAllUser();
    UserResponseDto updateUser(Long id,UserRequestDto userRequestDto);
    GenericResponseDto removeUserById(Long id);

    // custom finder methods
    UserResponseDto getUserByUsername(String username);
    List<UserResponseDto> getUserByName(String name);
    List<UserResponseDto> getUserByNameAndGender(String name, Gender gender);
    List<UserResponseDto> getUserWithGmailEmail(String domain);

}
