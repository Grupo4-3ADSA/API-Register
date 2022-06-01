package com.autog.register.service;

import com.autog.register.entity.Gestor;
import com.autog.register.repository.ManagerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {ManagerService.class})
class GestorServiceTest {

    @Autowired
    ManagerService service;

    @MockBean
    private ManagerRepository repository;

    @Test
    void registerEquipment() {

        Gestor m1 = new Gestor();

        ResponseEntity<List<Gestor>> response = service.registerEquipment(m1);

        assertEquals(201, response.getStatusCodeValue());
        assertNull(response.getBody());

    }

    @Test
    void getManagers() {

        Gestor m1 = mock(Gestor.class);
        Gestor m2 = mock(Gestor.class);

        List<Gestor> listMock = List.of(m1, m2);

        when(repository.findAll()).thenReturn(listMock);

        ResponseEntity<List<Gestor>> response = service.getManagers();

        assertNotNull(response.getBody());
        assertEquals(listMock, response.getBody());
        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    void editManager() {

        Gestor m1 = mock(Gestor.class);
        Gestor m2 = mock(Gestor.class);

        List<Gestor> listMock = List.of(m1);

        when(repository.existsById(1)).thenReturn(true);

        ResponseEntity<List<Gestor>> response = service.editManager(1, m2);

        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    void deleteManagerById() {

        Gestor m1 = new Gestor();
        Gestor m2 = new Gestor();

        Integer id = 1;
        m1.setIdManager(id);

        List<Gestor> listMock = List.of(m1, m2);

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity<List<Gestor>> response = service.deleteManagerById(id);

        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());

    }
}