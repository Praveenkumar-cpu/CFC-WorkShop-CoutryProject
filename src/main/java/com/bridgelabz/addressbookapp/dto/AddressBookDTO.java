package com.bridgelabz.addressbookapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

//Data transfer Object
//It is design pattern
//it hides details present in Entity
//it is close to entity it help to secure data

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {

    private int id;

    @NotEmpty(message = "FirstName CanNot be Null")
    @Pattern(regexp = "^[A-Z][a-z\\s]{2,}$",message = "First Name Should Starts With Capital Letter")

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private long pincode;



}
