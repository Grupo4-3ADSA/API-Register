package com.autog.register.repository;

import com.autog.register.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE Company s WHERE s.id = ?1")
    void deleteCompany(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Company s SET s.corporateName = ?2, s.cnpj = ?3, s.telephone = ?4, s.email = ?5 WHERE s.id = ?1")
    void updateCompany(Integer id, String corporateName, String cnpj, String telephone, String email);
}
