package com.autog.register.repository;

import com.autog.register.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    @Query("SELECT e FROM Equipment e WHERE clnBox.idCLNBox = ?1")
    List<Equipment> getEquipmentByClnBox(Integer idCLNBox);

    @Transactional
    @Modifying
    @Query("DELETE Equipment e WHERE e.idEquipment = ?1")
    void deleteEquipment(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Equipment e SET e.name = ?2 WHERE e.idEquipment = ?1")
    void updateEquipment(Integer id, String name);
}
