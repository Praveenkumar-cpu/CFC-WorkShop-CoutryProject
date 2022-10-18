package com.bridgelabz.addressbookapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "adressbook")
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pinCode;

    @NotEmpty(message = "Name Should Not Empty")
    @Min(value = 20,message = "write minimum number")
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @NotEmpty(message = "Name Should Not Empty")
    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "city")
    private String city;

}
