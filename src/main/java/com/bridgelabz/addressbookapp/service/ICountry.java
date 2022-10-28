package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.CountyDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.model.Country;

import java.util.List;

public interface ICountry {

    Country addCountry(CountyDTO countyDTO);
    List<Country> findCountryByFirstName(String countryName);
}
