package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.CountyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String countryName;
    private String capitalName;


    public Country(CountyDTO countyDTO) {
        this.countryName = countyDTO.getCountryName();
        this.capitalName = countyDTO.getCapitalName();

    }
}
