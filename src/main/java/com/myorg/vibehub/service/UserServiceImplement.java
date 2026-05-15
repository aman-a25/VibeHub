package com.myorg.vibehub.service;

import com.myorg.vibehub.dto.request.UserRequestDto;
import com.myorg.vibehub.dto.response.GenericResponseDto;
import com.myorg.vibehub.dto.response.UserResponseDto;
import com.myorg.vibehub.enums.Gender;
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

        User savedUser = userRepository.save(user);

        return mapUserToUserResponseDto(savedUser);

    }

    @Override
    public GenericResponseDto removeUserById(Long id) {

        User user = userRepository.findById(id).orElse(null);
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        if (user != null) {
            String name = user.getName();
            userRepository.delete(user);
            // we can also use deleteById(id) here That is a industry standard

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

        User savedUser = userRepository.save(user);

        return mapUserToUserResponseDto(savedUser);

    }

    @Override
    public UserResponseDto getUserById(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null; // OR throw exception OR custom response
        }

        return mapUserToUserResponseDto(user);

    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = new LinkedList<>();

        for (User user : userList) {

            UserResponseDto userResponseDto = mapUserToUserResponseDto(user);
            userResponseDtoList.add(userResponseDto);

            //one-liner for above
            //userResponseDtoList.add(mapUserToUserResponseDto(user));
        }
        return userResponseDtoList;
    }

    @Override
    public UserResponseDto getUserByUsername(String username) {
        User user = userRepository.findByUserName(username).orElse(null);
        if (user == null) {
            return null;
        }else {
            return mapUserToUserResponseDto(user);
        }
    }

    @Override
    public List<UserResponseDto> getUserByName(String name) {
        List<User> userList = userRepository.findByNameContaining(name);

        return mapListOfUserToListOfUserResponseDto(userList);

    }

    @Override
    public List<UserResponseDto> getUserByNameAndGender(String name, Gender gender) {
        List<User> userList = userRepository.findByNameAndGender(name, gender);

        return mapListOfUserToListOfUserResponseDto(userList);
    }

    @Override
    public List<UserResponseDto> getUserWithGmailEmail() {
        return mapListOfUserToListOfUserResponseDto(userRepository.findByEmail());
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

    //Map List<User> to UserResponseDTO
    private List<UserResponseDto> mapListOfUserToListOfUserResponseDto(List<User> userList) {

        List<UserResponseDto> userResponseDtoList = new LinkedList<>();
        for (User user : userList) {
            userResponseDtoList.add(mapUserToUserResponseDto(user));
        }
        return userResponseDtoList;
    }
}
