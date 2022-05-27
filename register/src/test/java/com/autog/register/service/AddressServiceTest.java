package com.autog.register.service;

import com.autog.register.entity.Address;
import com.autog.register.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AddressService.class})
class AddressServiceTest {

    @Autowired
    AddressService service;

    @MockBean
    private AddressRepository repository;

    @Test
    void registerAddress() {

        Address a1 = new Address();

        ResponseEntity<List<Address>> response = service.registerAddress(a1);

        assertEquals(201, response.getStatusCodeValue());
        assertNull(response.getBody());

    }

    @Test
    void updateAddress() {

        Address a1 = new Address();
        Address a2 = new Address();

        a1.setCity("sao paulo");
        a2.setCity("Rio de janeiro");



    }
}