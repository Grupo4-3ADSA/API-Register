package com.autog.register.repository;

import com.autog.register.dto.response.RoomResponse;
import com.autog.register.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("SELECT new com.autog.register.dto.response.RoomResponse(r.idRoom, r.name, r.floor) FROM Room r")
    List<RoomResponse> selectedList();

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
