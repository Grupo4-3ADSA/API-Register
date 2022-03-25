package com.autog.register.repository;

import com.autog.register.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    @Transactional
    @Modifying
    @Query("delete Empresa s where s.id = ?1")
    void deleteCompany(Integer id);

    @Transactional
    @Modifying
    @Query("update Empresa s set s.razaoSocial = ?2, s.cnpj = ?3, s.telefone = ?4, s.email = ?5 where s.id = ?1")
    void updateCompany(Integer id, String razaoSocial, String cnpj, String telefone, String email);
}
