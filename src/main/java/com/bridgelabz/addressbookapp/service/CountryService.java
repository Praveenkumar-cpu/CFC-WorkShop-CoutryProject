package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.CountyDTO;
import com.bridgelabz.addressbookapp.model.Country;
import com.bridgelabz.addressbookapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountry{


    @Autowired
    CountryRepository countryRepository;


    @Override
    public Country addCountry(CountyDTO countyDTO) {
        Country country = new Country(countyDTO);
        return countryRepository.save(country);
    }

    @Override
    public List<Country> findCountryByFirstName(String countryName) {
        return countryRepository.findCountryByFirstName(countryName);
    }
}
