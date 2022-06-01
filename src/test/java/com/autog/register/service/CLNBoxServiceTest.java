package com.autog.register.service;

import com.autog.register.entity.CLNBox;
import com.autog.register.repository.CLNBoxRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {CLNBoxService.class})
class CLNBoxServiceTest {

    @Autowired
    CLNBoxService service;

    @MockBean
    private CLNBoxRepository repository;

    @Test
    void registerCLNBox() {

        CLNBox c1 = new CLNBox();

        ResponseEntity<List<CLNBox>> response = service.registerCLNBox(c1);

        assertEquals(201, response.getStatusCodeValue());
        assertNull(response.getBody());

    }

    @Test
    void getCLNBox() {

        CLNBox c1 = mock(CLNBox.class);
        CLNBox c2 = mock(CLNBox.class);

        List<CLNBox> listMock = List.of(c1, c2);

        when(repository.findAll()).thenReturn(listMock);

        ResponseEntity<List<CLNBox>> response = service.getCLNBox();

        assertEquals(listMock, response.getBody());
        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    void editCLNBox() {

        CLNBox c1 = mock(CLNBox.class);
        CLNBox c2 = mock(CLNBox.class);

        List<CLNBox> listMock = List.of(c1);

        when(repository.existsById(1)).thenReturn(true);

        ResponseEntity<List<CLNBox>> response = service.editCLNBox(1, c2);

        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    void deleteCLNBoxById() {

        CLNBox c1 = new CLNBox();
        CLNBox c2 = new CLNBox();

        Integer id = 1;
        c1.setIdCLNBox(id);

        List<CLNBox> listMock = List.of(c1, c2);

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity<List<CLNBox>> response = service.deleteCLNBoxById(id);

        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());

    }
}