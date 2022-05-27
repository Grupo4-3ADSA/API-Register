package com.autog.register.service;

import com.autog.register.entity.Building;
import com.autog.register.repository.BuildingRepository;
import com.autog.register.repository.EquipmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {BuildingService.class})
class BuildingServiceTest {

    @Autowired
    BuildingService service;

    @MockBean
    private BuildingRepository repository;

    @Test
    void registerBuilding() {

        Building b1 = new Building();

        ResponseEntity<List<Building>> response = service.registerBuilding(b1);

        assertEquals(201, response.getStatusCodeValue());
        assertNull(response.getBody());


    }
}