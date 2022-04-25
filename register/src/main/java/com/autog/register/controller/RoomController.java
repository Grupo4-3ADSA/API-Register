package com.autog.register.controller;

import com.autog.register.dto.request.RoomRequest;
import com.autog.register.dto.response.RoomResponse;
import com.autog.register.entity.Room;
import com.autog.register.repository.RoomRepository;
import com.autog.register.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService service;
    
    @PostMapping
    public ResponseEntity registerRoom(@RequestBody @Valid Room newRoom) {
        return service.registerRoom(newRoom);
    }
    
    
    @GetMapping
    public ResponseEntity listAllRooms() {
        return service.listAllRooms();
    }

    @PutMapping("/{id}")
    public ResponseEntity editRoom(@PathVariable Integer id, @RequestBody @Valid RoomRequest request) {
        return service.editRoom(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRoom(@PathVariable Integer id) {
        return service.deleteRoom(id);
    }
}
