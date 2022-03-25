package com.autog.register.controller;

import com.autog.register.entity.Building;
import com.autog.register.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    @Autowired
    private BuildingRepository repository;

    @PostMapping
    public ResponseEntity registerBuilding(@RequestBody @Valid Building newBuilding) {
        repository.save(newBuilding);
        return ResponseEntity.status(201).build();
    }
}
