package com.autog.register.controller;

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
}
