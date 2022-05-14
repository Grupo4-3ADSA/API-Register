package com.autog.register.service;

import com.autog.register.entity.Company;
import com.autog.register.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository repository;

    public ResponseEntity registerEquipment(Company.Manager newManager) {
        repository.save(newManager);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity getManagers() {
        List<Company.Manager> managers = repository.findAll();
        if (managers.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(managers);
    }

    public ResponseEntity editManager(Integer id, Company.Manager request) {
        if (repository.existsById(id)) {
            repository.updateManager(id, request.getName(), request.getLogin(), request.getPassword());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    public ResponseEntity deleteManagerById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteManager(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
