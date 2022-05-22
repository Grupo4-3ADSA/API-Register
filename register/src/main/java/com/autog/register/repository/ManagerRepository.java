package com.autog.register.repository;

import com.autog.register.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE Manager m WHERE m.idManager = ?1")
    void deleteManager(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Manager m SET m.nameManager = ?2, m.login = ?3, m.password = ?4 WHERE m.idManager = ?1")
    void updateManager(Integer id, String name, String login, String password);
}
