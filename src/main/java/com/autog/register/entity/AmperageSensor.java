package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "SensorAmperagem")
public class AmperageSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSensorLuminosidade")
    private Integer idAmperageSensor;

    @NotNull
    @Column(name = "amperagem")
    private Double amperage;

    @NotNull
    @Column(name = "data")
    private LocalDateTime date;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkEquipamento")
    private Equipment equipment;

    public Integer getIdAmperageSensor() {
        return idAmperageSensor;
    }

    public void setIdAmperageSensor(Integer idAmperageSensor) {
        this.idAmperageSensor = idAmperageSensor;
    }

    public Double getAmperage() {
        return amperage;
    }

    public void setAmperage(Double amperage) {
        this.amperage = amperage;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
