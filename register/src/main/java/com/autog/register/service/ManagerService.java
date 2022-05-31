package com.autog.register.service;

import com.autog.register.entity.Gestor;
import com.autog.register.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository repository;

    public ResponseEntity registerEquipment(Gestor newGestor) {
        repository.save(newGestor);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity getManagers() {
        List<Gestor> gestors = repository.findAll();
        if (gestors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(gestors);
    }

    public ResponseEntity editManager(Integer id, Gestor request) {
        if (repository.existsById(id)) {
            repository.updateManager(id, request.getName(), request.getLogin(), request.getPassword());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity deleteManagerById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteByIdManager(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
