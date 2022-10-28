package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Integer> {


    @Query(value = "select * from  where CountryName = CountryName", nativeQuery = true)
    List<Country> findCountryByFirstName(String CountryName);
}
