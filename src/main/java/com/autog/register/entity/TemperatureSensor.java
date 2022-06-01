package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "SensorTemperatura")
public class TemperatureSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSensorTemperatura")
    private Integer idTemperatureSensor;

    @NotNull
    @Column(name = "temperatura")
    private Double temperature;

    @NotNull
    @Column(name = "data")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "fkEquipamento", referencedColumnName = "idEquipamento")
    private Equipment equipment;

    public Integer getIdTemperatureSensor() {
        return idTemperatureSensor;
    }

    public void setIdTemperatureSensor(Integer idTemperatureSensor) {
        this.idTemperatureSensor = idTemperatureSensor;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
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
