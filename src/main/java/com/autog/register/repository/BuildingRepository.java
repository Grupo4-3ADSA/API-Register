package com.autog.register.repository;

import com.autog.register.entity.Building;
import com.autog.register.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
    @Query("SELECT b FROM Building b JOIN Company c WHERE c.idCompany = ?1")
    List<Building> getBuildingByCompany(Integer idCompany);

    Building findByIdBuilding(Integer idPredio);


}
