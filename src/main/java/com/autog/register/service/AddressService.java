package com.autog.register.service;

import com.autog.register.entity.Address;
import com.autog.register.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public ResponseEntity registerAddress(Address newAddress) {
        repository.save(newAddress);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity updateAddress(Integer id, Address request) {
        if (repository.existsById(id)) {
            repository.updateAddress(
                    id,
                    request.getPublicPlace(),
                    request.getNumber(),
                    request.getDistrict(),
                    request.getCity(),
                    request.getState());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}