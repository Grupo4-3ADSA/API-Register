package com.autog.register.controller;

import com.autog.register.dto.request.RoomRequest;
import com.autog.register.dto.response.RoomResponse;
import com.autog.register.entity.Room;
import com.autog.register.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomRepository repository;

    @PostMapping
    public ResponseEntity registerRoom(@RequestBody @Valid Room newRoom) {
        repository.save(newRoom);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity listAllRooms() {
        List<RoomResponse> selectedList = repository.selectedList();
        if (selectedList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(selectedList);
    }

    @PatchMapping("/{id}")
    public ResponseEntity editRoom(@PathVariable Integer id, @RequestBody @Valid RoomRequest request) {
        if (repository.existsById(id)) {
            repository.updateRoom(id, request.getName(), request.getFloor());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRoom(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteRoom(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
