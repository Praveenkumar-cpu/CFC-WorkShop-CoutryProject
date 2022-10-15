package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@restcontroller is concenient that combines @Controller and @ResponseBody
//it eliminate need of @Reqbody for every req method


@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    private AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        super();
        this.addressBookService = addressBookService;
    }

    // build create AddressBook Rest API
    // we can provide complete resposonse to this class
    // create record with post method
    @PostMapping()
    public ResponseEntity<AddressBook> saveAddressBook(@RequestBody AddressBook addressBook){
        return new ResponseEntity<AddressBook>(addressBookService.saveAddressBook(addressBook), HttpStatus.CREATED);


    };
}
