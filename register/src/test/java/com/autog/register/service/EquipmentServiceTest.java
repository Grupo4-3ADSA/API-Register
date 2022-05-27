package com.autog.register.service;

import com.autog.register.entity.Equipment;
import com.autog.register.repository.EquipmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {EquipmentService.class})
class EquipmentServiceTest {

    @Autowired
    EquipmentService service;

    @MockBean
    private EquipmentRepository repository;

    @Test
    void registerEquipment() {

        Equipment e1 = new Equipment();

        ResponseEntity<List<Equipment>> response = service.registerEquipment(e1);

        assertEquals(201, response.getStatusCodeValue());
        assertNull(response.getBody());

    }

    @Test
    void getEquipment() {

        Equipment e1 = mock(Equipment.class);
        Equipment e2 = mock(Equipment.class);

        List<Equipment> listMock = List.of(e1, e2);

        ResponseEntity<List<Equipment>> response = service.getEquipment(1);

        when(repository.getEquipmentByCompany(1)).thenReturn(listMock);

        assertNotNull(response.getBody());
        assertEquals(listMock, response.getBody());
        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    void editEquipment() {
    }

    @Test
    void deleteEquipmentById() {

        Equipment e1 = new Equipment();

        Integer id = 1;
        e1.setIdEquipment(id);

        List<Equipment> listMock = List.of(e1);

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity<List<Equipment>> response = service.deleteEquipmentById(id);

        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());

    }
}