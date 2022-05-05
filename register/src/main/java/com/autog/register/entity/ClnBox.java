package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "CLNBox")
public class ClnBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClnBox;

    @NotBlank
    private String qrCode;

    @NotBlank
    private String ip;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkSala")
    private Room room;

    public Integer getIdClnBox() {
        return idClnBox;
    }

    public void setIdClnBox(Integer idClnBox) {
        this.idClnBox = idClnBox;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
