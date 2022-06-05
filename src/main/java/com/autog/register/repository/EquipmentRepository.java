package com.autog.register.repository;

import com.autog.register.dto.response.EquipmentResponse;
import com.autog.register.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    @Query("SELECT e FROM Equipment e WHERE clnBox.idCLNBox = ?1")
    List<Equipment> getEquipmentByClnBox(Integer idCLNBox);

    @Query(value="SELECT \n" +
            "s.id_sala,\n" +
            " s.nome as s_nome," +
            " s.andar,\n" +
            "  e.id_equipamento,\n" +
            "   e.nome, e.tipo, \n" +
            "   e.instalacao, \n" +
            "   e.vida_util,\n" +
            "    e.potencia,\n" +
            "\t e.qtd_equipamento,\n" +
            "\t  e.porta\n" +
            "FROM [dbo].[sala] as s\n" +
            "INNER JOIN [dbo].[clnbox] as c\n" +
            "ON s.id_sala = c.fk_sala\n" +
            "INNER JOIN [dbo].[equipamento] as e\n" +
            "ON c.id_clnbox = e.fk_clnbox\n" +
            "WHERE c.id_clnbox = ?1",
            nativeQuery=true)
    List<Object[]> getEquipmentAndRoomByClnBox(Integer idCLNBox);

    @Query(value="SELECT \n" +
            "s.id_sala,\n" +
            " s.nome as s_nome," +
            " s.andar,\n" +
            "  e.id_equipamento,\n" +
            "   e.nome, e.tipo, \n" +
            "   e.instalacao, \n" +
            "   e.vida_util,\n" +
            "    e.potencia,\n" +
            "\t e.qtd_equipamento,\n" +
            "\t  e.porta\n" +
            "FROM [dbo].[sala] as s\n" +
            "INNER JOIN [dbo].[clnbox] as c\n" +
            "ON s.id_sala = c.fk_sala\n" +
            "INNER JOIN [dbo].[equipamento] as e\n" +
            "ON c.id_clnbox = e.fk_clnbox\n",
            nativeQuery=true)
    List<Object[]> getAllEquipments();


    @Transactional
    @Modifying
    @Query("DELETE Equipment e WHERE e.idEquipment = ?1")
    void deleteEquipment(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Equipment e SET e.name = ?2 WHERE e.idEquipment = ?1")
    void updateEquipment(Integer id, String name);

    @Query("SELECT e FROM Equipment e WHERE idEquipment = ?1")
    List<Equipment> getEquip(Integer idEquipment);
}
