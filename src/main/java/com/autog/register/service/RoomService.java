package com.autog.register.service;

import com.autog.register.dto.request.RoomRequest;
import com.autog.register.dto.response.RoomResponse;
import com.autog.register.dto.response.RoomWthClnBox;
import com.autog.register.entity.Room;
import com.autog.register.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    public ResponseEntity registerRoom(Room newRoom) {
        repository.save(newRoom);
        return status(201).build();
    }

    public ResponseEntity listWithClnBox(Integer idBuilding) {
        List<RoomWthClnBox> selectedList = repository.selectedListWithClnBox(idBuilding);
        return selectedList.isEmpty() ? noContent().build() : ok().body(selectedList);
    }

    public ResponseEntity listAllRooms(Integer idBuilding) {
        List<RoomResponse> selectedList = repository.selectedList(idBuilding);
        return selectedList.isEmpty() ? noContent().build() : ok().body(selectedList);
    }

    @CrossOrigin
    public ResponseEntity editRoom(Integer id, RoomRequest request) {
        if (repository.existsById(id)) {
            repository.updateRoom(id, request.getName(), request.getFloor());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    public ResponseEntity deleteRoom(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteByIdRoom(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
