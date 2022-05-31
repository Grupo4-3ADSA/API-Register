package com.autog.register.repository;

import com.autog.register.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface RegisterRepository extends JpaRepository<Register, Integer> {

    List<Register> findRegisterByEquipmentAndDateBetween(Integer fkEquipamento, String inicio, String fim);
    List<Register> findRegisterByEquipmentByDate_MonthAndDate_Year()

}
