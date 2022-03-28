package com.autog.register.service;

import com.autog.register.dto.request.CompanyUpdateData;
import com.autog.register.entity.Company;
import com.autog.register.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public ResponseEntity registerCompany(Company newCompany) {
        repository.save(newCompany);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity getCompanies() {
        List<Company> companies = repository.findAll();
        if (companies.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(companies);
    }

    public ResponseEntity deleteCompanyById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteCompany(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    public ResponseEntity updateCompany(Integer id, CompanyUpdateData request) {
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
