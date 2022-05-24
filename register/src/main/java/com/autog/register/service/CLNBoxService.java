package com.autog.register.service;

import com.autog.register.dto.request.EquipmentRequest;
import com.autog.register.entity.CLNBox;
import com.autog.register.entity.Equipment;
import com.autog.register.repository.CLNBoxRepository;
import com.autog.register.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CLNBoxService {

    @Autowired
    private CLNBoxRepository repository;

    public ResponseEntity registerCLNBox(CLNBox newCLNBox) {
        repository.save(newCLNBox);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity getCLNBox() {
        List<CLNBox> clnBoxes = repository.findAll();
        if (clnBoxes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(clnBoxes);
    }

    public ResponseEntity editCLNBox(Integer id, CLNBox newCLNBox) {
        if (repository.existsById(id)) {
            repository.updateCLNBox(id, newCLNBox.getQrCode(), newCLNBox.getIp());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    public ResponseEntity deleteCLNBoxById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteCLNBox(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}