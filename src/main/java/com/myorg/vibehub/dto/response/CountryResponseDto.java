package com.myorg.vibehub.dto.response;

import lombok.Data;

@Data
public class CountryResponseDto {

    private Long id;
    private String countryName;
    private String slugName;
    private String countryTelephoneCode;

}
