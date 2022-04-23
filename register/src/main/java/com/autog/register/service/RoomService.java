package com.autog.register.service;

import com.autog.register.dto.request.RoomRequest;
import com.autog.register.dto.response.RoomResponse;
import com.autog.register.entity.Room;
import com.autog.register.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    public ResponseEntity registerRoom(Room newRoom) {
        repository.save(newRoom);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity listAllRooms() {
        List<RoomResponse> selectedList = repository.selectedList();
        if (selectedList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(selectedList);
    }

    @CrossOrigin
    public ResponseEntity editRoom(Integer id, RoomRequest request) {
        if (repository.existsById(id)) {
            repository.updateRoom(id, request.getName(), request.getFloor());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    public ResponseEntity deleteRoom(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteRoom(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
