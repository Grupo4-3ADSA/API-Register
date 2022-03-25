package com.autog.register.controller;

import com.autog.register.dto.request.CompanyUpdateData;
import com.autog.register.entity.Company;
import com.autog.register.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository repository;

    @PostMapping
    public ResponseEntity registerCompany(@RequestBody @Valid Company novaEmpresa) {
        repository.save(novaEmpresa);

        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getCompanies() {
        List<Company> companies = repository.findAll();
        if (companies.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(companies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompanyById(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteCompany(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCompany(
            @PathVariable Integer id,
            @RequestBody @Valid CompanyUpdateData request) {
        if (repository.existsById(id)) {
            repository.updateCompany(
                    id,
                    request.getCorporateName(),
                    request.getCnpj(),
                    request.getTelephone(),
                    request.getEmail());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
