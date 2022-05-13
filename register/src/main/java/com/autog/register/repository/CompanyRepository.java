package com.autog.register.repository;

import com.autog.register.dto.response.FormattedReport;
import com.autog.register.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

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

//    @Query("select g.nome, e.razao_social, e.cnpj, p.nome, end.logradouro, end.numero, end.cep from empresa e join \n" +
//            "gestor g on g.fk_empresa = e.id_empresa  join \n" +
//            "predio p on p.fk_empresa = e.id_empresa join\n" +
//            "endereco end on end.fk_predio = p.id_predio and p.id_predio = 1? and g.id_gestor limit 1;")
//    FormattedReport corpoUm(int idPredio);
}
