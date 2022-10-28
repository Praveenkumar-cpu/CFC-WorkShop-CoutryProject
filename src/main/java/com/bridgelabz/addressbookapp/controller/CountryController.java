package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.CountyDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.Country;
import com.bridgelabz.addressbookapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
        CountryService countryService;

    @PostMapping("/adduser")
    public ResponseEntity<ResponseDTO> addUserDeatils(@RequestBody CountyDTO countyDTO)
    {
        Country country = countryService.addCountry(countyDTO);
        ResponseDTO responseDTO = new ResponseDTO("ADDED SUCCESSFULL",country);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @GetMapping("name")
    public ResponseEntity<ResponseDTO> getCountryDetailByName(@PathVariable("name")String name)
    {
        List<Country> countries = countryService.findCountryByFirstName(name);
        ResponseDTO responseDTO = new ResponseDTO("Get Call success",countries);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

}
