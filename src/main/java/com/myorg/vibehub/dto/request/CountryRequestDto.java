package com.myorg.vibehub.dto.request;

import lombok.Data;

@Data
public class CountryRequestDto {

    private String countryName;
    private String slugName;
    private String countryTelephoneCode;
}
