package com.myorg.vibehub.dto.response;

import lombok.Data;

@Data
public class GenericResponseDto {
    private Boolean success;
    private String message;
    private Object details;

}
