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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

        Address a1 = mock(Address.class);
        Address a2 = mock(Address.class);

        List<Address> listMock = List.of(a1);

        when(repository.existsById(1)).thenReturn(true);

        ResponseEntity<List<Address>> response = service.updateAddress(1, a2);

        assertEquals(200, response.getStatusCodeValue());


    }
}