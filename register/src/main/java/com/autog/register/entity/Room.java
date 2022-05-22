package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotNull
    @Column(name = "andar")
    private Integer floor;

    @ManyToOne
    @JoinColumn(name = "fkBuilding", referencedColumnName = "idPredio")
    private Building building;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkClnbox")
    private ClnBox clnBox;

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

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
