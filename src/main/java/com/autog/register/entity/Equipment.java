package com.autog.register.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Equipamento")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipamento")
    private Integer idEquipment;

    @NotBlank
    @Column(name = "nome")
    private String name;

    @NotBlank
    @Column(name = "tipo")
    private String type;

    @NotNull
    @Column(name = "instalacao")
    private LocalDate installationDate;

    @Column(name = "vidaUtil")
    private Integer lifespan;

    @NotNull
    @Column(name = "potencia")
    private Integer potency;

    @Column(name = "qtdEquipamento")
    private Integer qtdEquipment;

    @Column(name = "porta")
    private Integer door;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "fkClnbox", referencedColumnName = "idCLNBox")
    private CLNBox clnBox;

    public Integer getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(Integer idEquipment) {
        this.idEquipment = idEquipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(LocalDate installationDate) {
        this.installationDate = installationDate;
    }

    public Integer getLifespan() {
        return lifespan;
    }

    public void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPotency() {
        return potency;
    }

    public void setPotency(Integer potency) {
        this.potency = potency;
    }

    public Integer getQtdEquipment() {
        return qtdEquipment;
    }

    public void setQtdEquipment(Integer qtdEquipment) {
        this.qtdEquipment = qtdEquipment;
    }

    public Integer getDoor() {
        return door;
    }

    public void setDoor(Integer door) {
        this.door = door;
    }

//    @JsonIgnore
//    public CLNBox getClnBox() {
//        return clnBox;
//    }

    public void setClnBox(CLNBox clnBox) {
        this.clnBox = clnBox;
    }
}
