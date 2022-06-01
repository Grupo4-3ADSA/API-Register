package com.autog.register.service;

import com.autog.register.controller.RoomController;
import com.autog.register.dto.request.RoomRequest;
import com.autog.register.dto.response.RoomResponse;
import com.autog.register.entity.Room;
import com.autog.register.repository.RoomRepository;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {RoomService.class})
class RoomServiceTest {

//    @Autowired
//    RoomService service;
//
//    @MockBean
//    private RoomRepository repository;
//
//    @MockBean
//    private RoomResponse roomResponse;
//
//    @Test
//    void listAllRooms() {
//
//        RoomResponse sala1 = mock(RoomResponse.class);
//        RoomResponse sala2 = mock(RoomResponse.class);
//        List<RoomResponse> listMock = List.of(sala1, sala2);
//
//        when(repository.selectedList()).thenReturn(listMock);
//
//        ResponseEntity<List<Room>> response = service.listAllRooms();
//
//        assertNotNull(response.getBody());
//        assertEquals(listMock, response.getBody());
//        assertEquals(200, response.getStatusCodeValue());
//
//    }
//
//    @Test
//    void registerRoom() {
//
//        Room r1 = new Room();
//
//        ResponseEntity<List<Room>> response = service.registerRoom(r1);
//
//        assertEquals(201, response.getStatusCodeValue());
//        assertNull(response.getBody());
//
//    }
//
//    @Test
//    void listAllRoomsListaVazia(){
//
//        when(repository.selectedList()).thenReturn(new ArrayList<>());
//
//        ResponseEntity<List<Room>> response = service.listAllRooms();
//
//        assertEquals(204, response.getStatusCodeValue());
//
//        assertNull(response.getBody());
//
//    }
//
//    @Test
//    void editRoom() {
//
//        RoomRequest r1 = mock(RoomRequest.class);
//        RoomResponse sala1 = mock(RoomResponse.class);
//        RoomResponse sala2 = mock(RoomResponse.class);
//        List<RoomResponse> listMock = List.of(sala1, sala2);
//
//        when(repository.existsById(1)).thenReturn(true);
//
//        ResponseEntity<List<Room>> response = service.editRoom(1, r1);
//
//        assertEquals(200, response.getStatusCodeValue());
//
//    }
//
//    @Test
//    void deleteRoomSemTerId(){
//
//        ResponseEntity<List<Room>> response = service.deleteRoom(1);
//
//        Integer id = 1;
//
//        when(repository.existsById(id)).thenReturn(false);
//
//        assertEquals(404, response.getStatusCodeValue());
//
//    }
//
//    @Test
//    void deleteRoom() {
//
//        Room r1 = new Room();
//        Room r2 = new Room();
//        Room r3 = new Room();
//
//        Integer id = 1;
//        r1.setIdRoom(id);
//
//        List<Room> listMock = List.of(r1, r2, r3);
//
//        when(repository.existsById(id)).thenReturn(true);
//
//        ResponseEntity<List<Room>> response = service.deleteRoom(id);
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertNull(response.getBody());
//
//    }
}