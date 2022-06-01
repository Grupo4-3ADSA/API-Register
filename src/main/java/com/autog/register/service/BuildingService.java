package com.autog.register.service;

import com.autog.register.entity.Building;
import com.autog.register.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository repository;

    public ResponseEntity registerBuilding(Building newBuilding) {
        repository.save(newBuilding);
        return ResponseEntity.status(201).build();
    }
}
