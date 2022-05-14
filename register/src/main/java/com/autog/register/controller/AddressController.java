package com.autog.register.controller;

import com.autog.register.entity.Company;
import com.autog.register.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/adresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping
    public ResponseEntity registerAddress(@RequestBody @Valid Company.Address newAddress) {
        return service.registerAddress(newAddress);
    }

    @PatchMapping("{id}")
    public ResponseEntity updateAddress(@PathVariable Integer id, @RequestBody @Valid Company.Address request) {
        return service.updateAddress(id, request);
    }
}
