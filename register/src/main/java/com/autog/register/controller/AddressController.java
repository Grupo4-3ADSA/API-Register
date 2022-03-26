package com.autog.register.controller;

import com.autog.register.dto.response.RoomResponse;
import com.autog.register.entity.Address;
import com.autog.register.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/adresses")
public class AddressController {

    @Autowired
    private AddressRepository repository;

    @PostMapping
    public ResponseEntity registerAddress(@RequestBody @Valid Address newAddress) {
        repository.save(newAddress);
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("{id}")
    public ResponseEntity updateAddress(@PathVariable Integer id, @RequestBody @Valid Address request) {
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
