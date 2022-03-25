package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Sala")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSala")
    private Integer idRoom;

    @NotBlank
    @Column(name = "nome")
    private String name;

    @NotBlank
    @Column(name = "andar")
    private String floor;

   // @OneToMany
    //@JoinColumn(name = "fkPredio")
    private Integer fkBuilding;

    //@OneToMany(mappedBy = "Predio")
    //private List<Equipamento> equipamentos = new ArrayList();

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getFkBuilding() {
        return fkBuilding;
    }

    public void setFkBuilding(Integer fkBuilding) {
        this.fkBuilding = fkBuilding;
    }

   // public List<Equipamento> getEquipamentos() {
   //     return equipamentos;
   // }

   // public void setEquipamentos(List<Equipamento> equipamentos) {
    //    this.equipamentos = equipamentos;
    //}
}
