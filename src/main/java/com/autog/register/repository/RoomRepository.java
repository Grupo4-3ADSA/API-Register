package com.autog.register.repository;

import com.autog.register.dto.response.RoomResponse;
import com.autog.register.dto.response.RoomWthClnBox;
import com.autog.register.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("SELECT new com.autog.register.dto.response.RoomResponse(r.idRoom, r.name, r.floor) FROM Room r where building.idBuilding = ?1")
    List<RoomResponse> selectedList(Integer idBuilding);

    @Query("SELECT new com.autog.register.dto.response.RoomWthClnBox(r.idRoom, r.name, r.floor, r.clnBox.idCLNBox) FROM Room r where building.idBuilding = ?1")
    List<RoomWthClnBox> selectedListWithClnBox(Integer idBuilding);

    @Query("SELECT r FROM Room r JOIN Company c WHERE c.idCompany = ?1")
    List<Room> getRoomByCompany(Integer idCompany);

    @Transactional
    @Modifying
    void deleteByIdRoom(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Room r SET r.name = ?2, r.floor = ?3 WHERE r.idRoom = ?1")
    void updateRoom(Integer id, String name, Integer floor);
}
