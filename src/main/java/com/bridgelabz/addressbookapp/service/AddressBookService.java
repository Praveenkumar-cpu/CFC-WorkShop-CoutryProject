package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.model.AddressBook;

import java.util.List;

public interface AddressBookService {

    AddressBook saveAddressBook(AddressBook addressBook);
    List<AddressBook> getAllDetails();
    AddressBook getAddressByPinCode(long pinCode);

    AddressBook updateAddressBook(AddressBook addressBook,long pincode);

    void deleteAddressBook(long pincode);


}
