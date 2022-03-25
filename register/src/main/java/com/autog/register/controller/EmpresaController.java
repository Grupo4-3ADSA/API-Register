package com.autog.register.controller;

import com.autog.register.dto.request.EmpresaUpdateData;
import com.autog.register.entity.Empresa;
import com.autog.register.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;

    @PostMapping
    public ResponseEntity registerCompany(@RequestBody @Valid Empresa novaEmpresa) {
        repository.save(novaEmpresa);

        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getCompanies() {
        List<Empresa> empresas = repository.findAll();
        if (empresas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(empresas);
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
            @RequestBody EmpresaUpdateData request) {
        if (repository.existsById(id)) {
            repository.updateCompany(
                    id,
                    request.getRazaoSocial(),
                    request.getCnpj(),
                    request.getTelefone(),
                    request.getEmail());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
