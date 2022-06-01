package com.autog.register.service;

import com.autog.register.dto.request.CompanyUpdateData;
import com.autog.register.entity.Company;
import com.autog.register.entity.Room;
import com.autog.register.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {CompanyService.class})
class CompanyServiceTest {

    @Autowired
    CompanyService service;

    @MockBean
    private CompanyRepository repository;

    @Test
    void registerCompany() {

        Company c1 = new Company();

        ResponseEntity<List<Company>> response = service.registerCompany(c1);

        assertEquals(201, response.getStatusCodeValue());
        assertNull(response.getBody());


    }

    @Test
    void getCompanies() {

        Company c1 = mock(Company.class);
        Company c2 = mock(Company.class);

        List<Company> listMock = List.of(c1, c2);

        when(repository.findAll()).thenReturn(listMock);

        ResponseEntity<List<Company>> response = service.getCompanies();

        assertNotNull(response.getBody());
        assertEquals(listMock, response.getBody());
        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    void deleteCompanyById() {

        Company c1 = new Company();

        Integer id = 1;
        c1.setIdCompany(id);

        List<Company> listMock = List.of(c1);

        when(repository.existsById(id)).thenReturn(true);

        ResponseEntity<List<Company>> response = service.deleteCompanyById(id);

        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());

    }

    @Test
    void updateCompany() {

        Company c1 = mock(Company.class);
        CompanyUpdateData cd1 = mock(CompanyUpdateData.class);

        List<Company> listMock = List.of(c1);

        when(repository.existsById(1)).thenReturn(true);

        ResponseEntity<List<Company>> response = service.updateCompany(1, cd1);

        assertEquals(200, response.getStatusCodeValue());

    }
}