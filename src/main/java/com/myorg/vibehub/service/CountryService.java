package com.myorg.vibehub.service;

import com.myorg.vibehub.dto.response.CountryResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CountryService {
    List<CountryResponseDto> getAllCountries();

    Page<CountryResponseDto> getAllCountriesPage(int pageIndex, int pageSize, String sortBy, String sortOrder);

}
