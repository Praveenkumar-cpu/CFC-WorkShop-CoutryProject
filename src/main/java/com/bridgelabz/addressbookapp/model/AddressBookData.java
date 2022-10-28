package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address_book")
public class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private long pincode;


    public AddressBookData(AddressBookDTO addressBookDTO) {

       this.updateAddressBookData(addressBookDTO);

    }

    public void updateAddressBookData(AddressBookDTO addressBookDTO){
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.email = addressBookDTO.getEmail();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.pincode = addressBookDTO.getPincode();

    }

}
