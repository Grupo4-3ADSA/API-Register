package com.autog.register.controller;

import com.autog.register.dto.request.EquipamentRequest;
import com.autog.register.entity.Equipment;
import com.autog.register.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipamentController {

    @Autowired
    private EquipmentRepository repository;

    @PostMapping
    public ResponseEntity registerEquipment(@RequestBody @Valid Equipment newEquipment) {
        repository.save(newEquipment);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getEquipment() {
        List<Equipment> equipments = repository.findAll();
        if (equipments.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(equipments);
    }

    @PatchMapping("/{id}")
    public ResponseEntity editEquipment(@PathVariable Integer id, @RequestBody @Valid EquipamentRequest request) {
        if (repository.existsById(id)) {
            repository.updateEquipment(id, request.getName());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEquipmentById(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteEquipment(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
