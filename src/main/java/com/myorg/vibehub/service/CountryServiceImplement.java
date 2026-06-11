package com.myorg.vibehub.service;

import com.myorg.vibehub.dto.request.CountryRequestDto;
import com.myorg.vibehub.dto.response.CountryResponseDto;
import com.myorg.vibehub.model.Country;
import com.myorg.vibehub.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;


@Service
public class CountryServiceImplement implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<CountryResponseDto> getAllCountries() {
        List<Country> countryList = countryRepository.findAll();
        List<CountryResponseDto> countryResponseDtoList = new LinkedList<>();
        for (Country country : countryList) {

            countryResponseDtoList.add( mapCountryToCountryResponseDto(country));

        }
        return countryResponseDtoList;
    }

    @Override
    public Page<CountryResponseDto> getAllCountriesPage(int pageIndex, int pageSize, String sortBy, String sortOrder) {
        Sort sort = (sortOrder.equalsIgnoreCase("ASC")) ?  Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageIndex , pageSize ,sort);
        Page<Country> countryPage = countryRepository.findAll(pageable);

        Page<CountryResponseDto>  countryResponseDtoPage = countryPage.map(country -> mapCountryToCountryResponseDto(country) );

        return countryResponseDtoPage;

    }

    //Helper methods
    private CountryResponseDto mapCountryToCountryResponseDto(Country country) {
        CountryResponseDto countryResponseDto = new CountryResponseDto();
        countryResponseDto.setId(country.getId());
        countryResponseDto.setCountryName(country.getCountryName());
        countryResponseDto.setSlugName(country.getSlugName());
        countryResponseDto.setCountryTelephoneCode(country.getCountryTelephoneCode());

        return countryResponseDto;
    }

    private Country mapCountryRequestDtoToCountry(CountryRequestDto countryRequestDto) {
        Country country = new Country();
        country.setCountryName(countryRequestDto.getCountryName());
        country.setSlugName(countryRequestDto.getSlugName());
        country.setCountryTelephoneCode(countryRequestDto.getCountryTelephoneCode());

        return country;
    }
}
