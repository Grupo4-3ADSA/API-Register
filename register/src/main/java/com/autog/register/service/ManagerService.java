package com.autog.register.service;

import com.autog.register.entity.Company;
import com.autog.register.entity.Manager;
import com.autog.register.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository repository;

    public ResponseEntity registerEquipment(Manager newManager) {
        repository.save(newManager);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity getManagers() {
        List<Manager> managers = repository.findAll();
        if (managers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(managers);
    }

    public ResponseEntity editManager(Integer id, Manager request) {
        if (repository.existsById(id)) {
            repository.updateManager(id, request.getName(), request.getLogin(), request.getPassword());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity deleteManagerById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteManager(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
