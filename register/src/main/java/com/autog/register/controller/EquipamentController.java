package com.autog.register.controller;

import com.autog.register.dto.request.EquipamentRequest;
import com.autog.register.entity.Equipment;
import com.autog.register.service.EquipamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/equipments")
public class EquipamentController {

    @Autowired
    private EquipamentService service;

    @PostMapping
    public ResponseEntity registerEquipment(@RequestBody @Valid Equipment newEquipment) {
        return service.registerEquipment(newEquipment);
    }

    @GetMapping
    public ResponseEntity getEquipment() {
        return service.getEquipment();
    }

    @PatchMapping("/{id}")
    public ResponseEntity editEquipment(@PathVariable Integer id, @RequestBody @Valid EquipamentRequest request) {
        return service.editEquipment(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEquipmentById(@PathVariable Integer id) {
        return service.deleteEquipmentById(id);
    }
}
