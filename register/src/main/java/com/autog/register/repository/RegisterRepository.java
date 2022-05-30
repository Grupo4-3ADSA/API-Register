package com.autog.register.repository;

import com.autog.register.entity.Register;
import com.autog.register.service.PilhaObj;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RegisterRepository extends JpaRepository<Register, Integer> {

    List<Register> getByEquipmentAndDateBetween(Integer fkEquipamento, Date inicio, Date fim);

}
