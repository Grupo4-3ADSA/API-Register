package com.autog.register.entity;

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

    @Column(name = "tipo")
    private String type;

    @Column(name = "potencia")
    private Integer potency;

    @Column(name = "qtdEquipamento")
    private Integer amountOfEquipment;

    @Column(name = "porta")
    private Integer port;

    @NotNull
    @Column(name = "instalacao")
    private LocalDate installationDate;

    @Column(name = "vidaUtil")
    private Integer lifespan;

  //  @ManyToOne
    @JoinColumn(name = "fkCLNBox", referencedColumnName = "idCLNBox")
    private Integer fkCLNBox;
  //  private Room room;

    public Integer getFkSala() {
        return fkCLNBox;
    }

    public void setFkSala(Integer fkSala) {
        this.fkCLNBox = fkSala;
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

    public Integer getAmountOfEquipment() {
        return amountOfEquipment;
    }

    public void setAmountOfEquipment(Integer amountOfEquipment) {
        this.amountOfEquipment = amountOfEquipment;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

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

   // public Room getRoom() {
 //       return room;
  //  }

   // public void setRoom(Room room) {
    //    this.room = room;
   // }
}
