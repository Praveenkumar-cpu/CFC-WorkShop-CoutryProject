package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl implements AddressBookService {
//Autowired
private AddressBookRepository addressBookRepository;

    public AddressBookServiceImpl(AddressBookRepository addressBookRepository) {
        super();
        this.addressBookRepository = addressBookRepository;
    }

    @Override
    public AddressBook saveAddressBook(AddressBook addressBook) {
        return addressBookRepository.save(addressBook);
    }
}
