package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@restcontroller is concenient that combines @Controller and @ResponseBody
//it Eliminate need of @Reqbody for every req method


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
    @PostMapping("/post")
    public ResponseEntity<AddressBook> saveAddressBook(@Valid @RequestBody AddressBook addressBook) {
        return new ResponseEntity<AddressBook>(addressBookService.saveAddressBook(addressBook), HttpStatus.CREATED);
    }

    //get all address REST API
    @GetMapping
    public List<AddressBook> getAllAddressDetails() {
        return addressBookService.getAllDetails();
    }

    //get by id
    @GetMapping("{id}")
    public ResponseEntity<AddressBook> getAddressBookpinCode(@PathVariable("id") long pinCode) {

        return new ResponseEntity<AddressBook>(addressBookService.getAddressByPinCode(pinCode),HttpStatus.OK);
    }

    //update rest api
    //http://loalhost:8080/api/addressbook/2
    @PutMapping("{id}")
    public ResponseEntity<AddressBook>updateAddressBook(@Valid @PathVariable("id")long pinCode,@RequestBody AddressBook addressBook){

        return new ResponseEntity<AddressBook>(addressBookService.updateAddressBook(addressBook,pinCode),HttpStatus.OK);

    }

    //build delete Addressbook
@DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable("id") long pinCode){
       addressBookService.deleteAddressBook(pinCode);
       return new ResponseEntity<String>("Address Book deleted successfully",HttpStatus.OK);


    }

}
