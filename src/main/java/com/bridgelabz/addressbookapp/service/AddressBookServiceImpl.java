package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.exception.ResourceNotFoundException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookServiceImpl implements AddressBookService {
//@Autowired
private AddressBookRepository addressBookRepository;

    public AddressBookServiceImpl(AddressBookRepository addressBookRepository) {
        super();
        this.addressBookRepository = addressBookRepository;
    }

    @Override
    public AddressBook saveAddressBook(AddressBook addressBook) {
        return addressBookRepository.save(addressBook);
    }

    @Override
    public List<AddressBook> getAllDetails() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBook getAddressByPinCode(long pinCode) {
//        Optional<AddressBook> addressBook = addressBookRepository.findById(pinCode);
//        if (addressBook.isPresent()){
//            return addressBook.get();
//        }else {
//            throw new ResourceNotFoundException("AddressBook","pinCode",pinCode);
//        }

        return addressBookRepository.findById(pinCode).orElseThrow(() ->
                new ResourceNotFoundException("AddressBook","pinCode",pinCode));
    }

    @Override
    public AddressBook updateAddressBook(AddressBook addressBook, long pincode) {
        //we need to check wheather with given id is exitst in DB or Not

        AddressBook existingAddressBook = addressBookRepository.findById(pincode).orElseThrow(
                () -> new ResourceNotFoundException("AddressBook","pinCode",pincode));
        existingAddressBook.setFirstName(addressBook.getFirstName());
        existingAddressBook.setLastName(addressBook.getLastName());
        existingAddressBook.setPinCode(addressBook.getPinCode());
        existingAddressBook.setEmail(addressBook.getEmail());
        existingAddressBook.setCity(addressBook.getCity());

        // save existing addressbook
        addressBookRepository.save(existingAddressBook);
        return existingAddressBook;
    }

    @Override
    public void deleteAddressBook(long pincode) {
        //check wheather addressbook db is exist or not

        addressBookRepository.findById(pincode).orElseThrow(() ->
                new ResourceNotFoundException("Addressbook","pinCode",pincode));
        addressBookRepository.deleteById(pincode);
    }
}
