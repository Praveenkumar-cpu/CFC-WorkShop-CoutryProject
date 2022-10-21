package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    @Autowired
    AddressBookData addressBookData;
    @Autowired
   private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookById(int id) {
        return addressBookRepository.findById(id).orElseThrow(()-> new AddressBookException("AddressBook With the id " + id + "does Not Exists"));
    }

    @Override
    public AddressBookData addAddressBookData(AddressBookDTO addressBookDTO) {
        addressBookData = new AddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData updateAddressBookByFirstName(int id, AddressBookDTO addressBookDTO) {
        addressBookData = this.getAddressBookById(id);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);

    }

    @Override
    public void deleteAddressBookByFirstName(int id) {
        addressBookData = this.getAddressBookById(id);
        addressBookRepository.delete(addressBookData);

    }

    @Override
    public List<AddressBookData> findAddressBookByFirstName(String firstname) {
        return addressBookRepository.findAddressBookDataByFirstname(firstname);
    }

    @Override
    public List<AddressBookData> findAddressBookByState(String state) {
        return addressBookRepository.findAddressBookDataByState(state);
    }


}
