package com.autog.register.controller;

import com.autog.register.dto.request.CompanyUpdateData;
import com.autog.register.entity.Company;
import com.autog.register.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @PostMapping
    public ResponseEntity registerCompany(@RequestBody @Valid Company newCompany) {
        return service.registerCompany(newCompany);
    }

    @GetMapping
    public ResponseEntity getCompanies() {
        return service.getCompanies();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompanyById(@PathVariable Integer id) {
        return service.deleteCompanyById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCompany(
            @PathVariable Integer id,
            @RequestBody @Valid CompanyUpdateData request) {
        return service.updateCompany(id, request);
    }
}