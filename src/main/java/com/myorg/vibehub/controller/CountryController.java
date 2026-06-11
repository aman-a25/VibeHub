package com.myorg.vibehub.controller;

import com.myorg.vibehub.dto.response.CountryResponseDto;
import com.myorg.vibehub.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryResponseDto>> getAllCountries() {
        List<CountryResponseDto> countryResponseDtoList = countryService.getAllCountries();

        return new ResponseEntity<>(countryResponseDtoList, HttpStatus.OK);

    }

    @GetMapping("/page")
    public ResponseEntity<Page<CountryResponseDto>> getAllCountriesPage(
            @RequestParam(defaultValue = "0") Integer pageIndex,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortOrder
            ) {
        Page<CountryResponseDto> countryResponseDtoPage = countryService.getAllCountriesPage(pageIndex ,  pageSize, sortBy, sortOrder);

        return new ResponseEntity<>(countryResponseDtoPage, HttpStatus.OK);

    }
}
