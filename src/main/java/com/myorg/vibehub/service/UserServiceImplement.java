package com.myorg.vibehub.service;

import com.myorg.vibehub.dto.request.UserRequestDto;
import com.myorg.vibehub.dto.response.GenericResponseDto;
import com.myorg.vibehub.dto.response.UserResponseDto;
import com.myorg.vibehub.model.User;
import com.myorg.vibehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;


@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDto updateUser(Long id ,UserRequestDto userRequestDto) {

        User user = mapUserRequestDtoToUser(userRequestDto);
        user.setId(id);

        User savedUser = userRepository.updateUser(user);

        return mapUserToUserResponseDto(savedUser);

    }

    @Override
    public GenericResponseDto removeUserById(Long id) {

        User user = userRepository.getUser(id);
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        if (user != null) {
            String name = user.getName();
            userRepository.removeUser(user.getId());

            genericResponseDto.setSuccess(true);

            genericResponseDto.setMessage("User name : "+ name +" has been removed successfully");
        } else {
            genericResponseDto.setSuccess(false);
            genericResponseDto.setMessage("User not found");
        }
        return genericResponseDto;


    }


    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {

        User user =  mapUserRequestDtoToUser(userRequestDto);

        User savedUser = userRepository.addUser(user);

        return mapUserToUserResponseDto(savedUser);

    }

    @Override
    public UserResponseDto getUserById(Long id) {

        return mapUserToUserResponseDto(userRepository.getUser(id));

    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> userList = userRepository.getAllUser();
        List<UserResponseDto> userResponseDtoList = new LinkedList<>();

        for (User user : userList) {

            UserResponseDto userResponseDto = mapUserToUserResponseDto(user);
            userResponseDtoList.add(userResponseDto);

            //one-liner for above
            //userResponseDtoList.add(mapUserToUserResponseDto(user));
        }
        return userResponseDtoList;
    }

    //helper methods
    // Map User to UserResponseDto
    private UserResponseDto mapUserToUserResponseDto(User user) {

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setUserName(user.getUserName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPhoneNumber(user.getPhoneNumber());
        userResponseDto.setGender(user.getGender());

        return userResponseDto;

    }

    //Map UserRequestDto to user
    private User mapUserRequestDtoToUser(UserRequestDto userRequestDto) {

        User user = new User();
        user.setName(userRequestDto.getName());
        user.setUserName(userRequestDto.getUserName());
        user.setPassword(userRequestDto.getPassword());
        user.setEmail(userRequestDto.getEmail());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setGender(userRequestDto.getGender());

        return user;

    }
}
