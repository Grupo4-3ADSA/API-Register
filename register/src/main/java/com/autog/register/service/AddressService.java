package com.autog.register.service;

import com.autog.register.entity.Company;
import com.autog.register.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public ResponseEntity registerAddress(Company.Address newAddress) {
        repository.save(newAddress);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity updateAddress(Integer id, Company.Address request) {
        if (repository.existsById(id)) {
            repository.updateAddress(
                    id,
                    request.getPublicPlace(),
                    request.getNumber(),
                    request.getDistrict(),
                    request.getCity(),
                    request.getState());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
