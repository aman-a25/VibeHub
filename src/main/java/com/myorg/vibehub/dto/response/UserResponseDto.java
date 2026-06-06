package com.myorg.vibehub.dto.response;

import com.myorg.vibehub.enums.Gender;
import com.myorg.vibehub.model.ProfilePicture;
import com.myorg.vibehub.model.Wallet;
import lombok.Data;

@Data
public class UserResponseDto {

    // This is the data that will go to control layer and control layer will directly send it to client that's why it does not have any password field
    private Long id;
    private String name;
    private String userName;
    private String email;
    private String phoneNumber;
    private Gender gender;
    private ProfilePicture profilePicture;
    private Wallet wallet;
}
