package com.bridgelabz.addressbookapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "adressbook")
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pinCode;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "city")
    private String city;


}
