package com.autog.register.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Agendamento")
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAgendamento")
    private Integer idScheduling;

    @Column(name = "data")
    private LocalDate date;

    @Column(name = "horario")
    private LocalTime hour;

    @Column(name = "ligar")
    private Boolean connected;

    @ManyToOne
    @JoinColumn(name = "fkSala", referencedColumnName = "idSala")
    private Room room;

    public Integer getIdScheduling() {
        return idScheduling;
    }

    public void setIdScheduling(Integer idScheduling) {
        this.idScheduling = idScheduling;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
