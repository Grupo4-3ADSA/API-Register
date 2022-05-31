package com.autog.register.controller;

import com.autog.register.entity.Gestor;
import com.autog.register.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerService service;

    @PostMapping
    public ResponseEntity registerEquipment(@RequestBody @Valid Gestor newGestor) {
        return service.registerEquipment(newGestor);
    }

    @GetMapping
    public ResponseEntity getManagers() {
        return service.getManagers();
    }

    @PatchMapping("/{id}")
    public ResponseEntity editManager(@PathVariable Integer id, @RequestBody @Valid Gestor request) {
        return service.editManager(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteManagerById(@PathVariable Integer id) {
        return service.deleteManagerById(id);
    }
}
