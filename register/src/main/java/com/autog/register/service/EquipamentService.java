package com.autog.register.service;

import com.autog.register.dto.request.EquipamentRequest;
import com.autog.register.entity.Equipment;
import com.autog.register.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentService {

    @Autowired
    private EquipmentRepository repository;

    public ResponseEntity registerEquipment(Equipment newEquipment) {
        repository.save(newEquipment);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity getEquipment() {
        List<Equipment> equipments = repository.findAll();
        if (equipments.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(equipments);
    }

    public ResponseEntity editEquipment(Integer id, EquipamentRequest request) {
        if (repository.existsById(id)) {
            repository.updateEquipment(id, request.getName());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    public ResponseEntity deleteEquipmentById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteEquipment(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
