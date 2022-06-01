package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "SensorLuminosidade")
public class BrightnessSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSensorLuminosidade")
    private Integer idBrightnessSensor;

    @NotNull
    @Column(name = "luminosidade")
    private Double brightness;

    @NotNull
    @Column(name = "data")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "fkEquipamento", referencedColumnName = "idEquipamento")
    private Equipment equipment;

    public Integer getIdBrightnessSensor() {
        return idBrightnessSensor;
    }

    public void setIdBrightnessSensor(Integer idBrightnessSensor) {
        this.idBrightnessSensor = idBrightnessSensor;
    }

    public Double getBrightness() {
        return brightness;
    }

    public void setBrightness(Double brightness) {
        this.brightness = brightness;
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
