package com.autog.register.repository;

import com.autog.register.entity.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ManagerRepository extends JpaRepository<Gestor, Integer> {

    @Transactional
    @Modifying
    void deleteByIdManager(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Gestor m SET m.nameManager = ?2, m.login = ?3, m.password = ?4 WHERE m.idManager = ?1")
    void updateManager(Integer id, String name, String login, String password);

    Gestor findByIdManager(Integer idManager);
}
