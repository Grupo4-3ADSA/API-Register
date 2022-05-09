package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "SensorPresenca")
public class PresenceSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSensorPresenca")
    private Integer idPresenceSensor;

    @NotNull
    @Column(name = "presenca")
    private boolean presence;

    @NotNull
    @Column(name = "data")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "fkEquipamento", referencedColumnName = "idEquipamento")
    private Equipment equipment;

    public Integer getIdPresenceSensor() {
        return idPresenceSensor;
    }

    public void setIdPresenceSensor(Integer idPresenceSensor) {
        this.idPresenceSensor = idPresenceSensor;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        presence = presence;
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
