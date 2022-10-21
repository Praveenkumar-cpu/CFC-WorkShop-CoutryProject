package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/home")
public class AddressBookController {

    @Autowired
    private ResponseDTO responseDTO;

   @Autowired
    private AddressBookService addressBookService;

    @GetMapping(value = {"","/","getall"})
    public ResponseEntity<ResponseDTO> getAddressBookData(){
        List<AddressBookData> addressBookDataList = addressBookService.getAddressBookData();
        responseDTO = new ResponseDTO("Get call success",addressBookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getid/{id}")
    public ResponseEntity<ResponseDTO>getAddressBookById(@PathVariable("id") int id){
        AddressBookData addressBookData = addressBookService.getAddressBookById(id);
        responseDTO = new ResponseDTO("Get Call for ID success",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<ResponseDTO>addAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = addressBookService.addAddressBookData(addressBookDTO);
        responseDTO = new ResponseDTO("Data Added Successfully",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO>updateAddressBookData(@Valid @PathVariable("id") int id, @RequestBody AddressBookDTO addressBookDTO){
    AddressBookData addressBookData = addressBookService.updateAddressBookByFirstName(id,addressBookDTO);
    responseDTO = new ResponseDTO("Address Book Updated successfully",addressBookData);
    return new ResponseEntity<>(responseDTO,HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("id") int id){
        addressBookService.deleteAddressBookByFirstName(id);
        responseDTO = new ResponseDTO("Deleted Successfully",id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }





}
