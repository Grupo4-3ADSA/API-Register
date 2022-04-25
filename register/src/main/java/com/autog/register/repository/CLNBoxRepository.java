package com.autog.register.repository;

import com.autog.register.entity.CLNBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CLNBoxRepository extends JpaRepository<CLNBox, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE CLNBox c WHERE c.idCLNBox = ?1")
    void deleteCLNBox(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE CLNBox c SET c.qrCode = ?2, c.ip = ?3 WHERE c.idCLNBox = ?1")
    void updateCLNBox(Integer id, String qrCode, String ip);
}
