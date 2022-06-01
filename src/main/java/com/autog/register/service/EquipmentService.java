package com.autog.register.service;

import com.autog.register.dto.request.EquipmentRequest;
import com.autog.register.entity.Equipment;
import com.autog.register.entity.Room;
import com.autog.register.repository.EquipmentRepository;
import com.autog.register.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository repository;

    public ResponseEntity registerEquipment(Equipment newEquipment) {
        repository.save(newEquipment);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity getEquipment(Integer idCLNBox) {
        List<Equipment> equipments = repository.getEquipmentByClnBox(idCLNBox);
        if (equipments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(equipments);
    }

    public ResponseEntity editEquipment(Integer id, EquipmentRequest request) {
        if (repository.existsById(id)) {
            repository.updateEquipment(id, request.getName());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity deleteEquipmentById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteEquipment(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
