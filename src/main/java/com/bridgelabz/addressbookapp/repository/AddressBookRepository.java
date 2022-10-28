package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//java Persistence api
//mainly used to managing data in Spring boot application
// it contain full api of crudrepository and pagingandsorting repository
@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer> {

    @Query(value = "select * from address_book where first_name = :firstname", nativeQuery = true)
    List<AddressBookData> findAddressBookDataByFirstname(String firstname);

    @Query(value = "select * from address_book where state = :state", nativeQuery = true)
    List<AddressBookData> findAddressBookDataByState(String state);

}
