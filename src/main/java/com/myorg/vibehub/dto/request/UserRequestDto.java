package com.myorg.vibehub.dto.request;

import com.myorg.vibehub.enums.Gender;
import lombok.Data;

@Data
public class UserRequestDto {

    // This is the data that control layer is going to receive from the client

    private String name;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private Gender gender;
    private Long countryId;
}
