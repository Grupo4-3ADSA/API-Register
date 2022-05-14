package com.autog.register.service;

import com.autog.register.dto.request.EquipmentRequest;
import com.autog.register.entity.Company;
import com.autog.register.entity.Equipment;
import com.autog.register.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository repository;

    public ResponseEntity registerEquipment(Company.Equipment newEquipment) {
        repository.save(newEquipment);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity getEquipment(Integer idCompany) {
        List<Equipment> equipments = repository.getEquipmentByCompany(idCompany);
        if (equipments.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(equipments);
    }

    public ResponseEntity editEquipment(Integer id, EquipmentRequest request) {
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
