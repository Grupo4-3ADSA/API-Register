package com.autog.register.service;

import com.autog.register.entity.Manager;
import com.autog.register.repository.ManagerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {ManagerService.class})
class ManagerServiceTest {

    @Autowired
    ManagerService service;

    @MockBean
    private ManagerRepository repository;

    @Test
    void registerEquipment() {

        Manager m1 = new Manager();

        ResponseEntity<List<Manager>> response = service.registerManager(m1);

        assertEquals(201, response.getStatusCodeValue());
        assertNull(response.getBody());

    }

    @Test
    void getManagers() {

        Manager m1 = mock(Manager.class);
        Manager m2 = mock(Manager.class);

        List<Manager> listMock = List.of(m1, m2);

        when(repository.findAll()).thenReturn(listMock);

        ResponseEntity<List<Manager>> response = service.getManagers();

        assertNotNull(response.getBody());
        assertEquals(listMock, response.getBody());
        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    void editManager() {

        Manager m1 = mock(Manager.class);
        Manager m2 = mock(Manager.class);

        List<Manager> listMock = List.of(m1);

        when(repository.existsById(1)).thenReturn(true);

        ResponseEntity<List<Manager>> response = service.editManager(1, m2);

        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    void deleteManagerById() {

        Manager m1 = new Manager();
        Manager m2 = new Manager();

        Integer id = 1;
        m1.setIdManager(id);

        List<Manager> listMock = List.of(m1, m2);

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity<List<Manager>> response = service.deleteManagerById(id);

        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());

    }
}