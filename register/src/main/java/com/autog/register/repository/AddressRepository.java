package com.autog.register.repository;

import com.autog.register.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Address a SET a.publicPlace = ?2, a.number = ?3, a.district = ?4, a.city = ?5, a.state = ?6 WHERE a.idAddress = ?1")
    void updateAddress(Integer id, String publicPlace, Integer number, String district, String city, String state);
}