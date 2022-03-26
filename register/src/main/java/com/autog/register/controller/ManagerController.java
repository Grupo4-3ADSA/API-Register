package com.autog.register.controller;

import com.autog.register.dto.request.EquipamentRequest;
import com.autog.register.entity.Equipment;
import com.autog.register.entity.Manager;
import com.autog.register.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerRepository repository;

    @PostMapping
    public ResponseEntity registerEquipment(@RequestBody @Valid Manager newManager) {
        repository.save(newManager);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getManagers() {
        List<Manager> managers = repository.findAll();
        if (managers.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(managers);
    }

    @PatchMapping("/{id}")
    public ResponseEntity editManager(@PathVariable Integer id, @RequestBody @Valid Manager request) {
        if (repository.existsById(id)) {
            repository.updateManager(id, request.getName(), request.getLogin(), request.getPassword());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteManagerById(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteManager(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
