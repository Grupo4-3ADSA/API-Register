package com.autog.register.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLNBox")
public class CLNBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClnbox")
    private Integer idCLNBox;

    @Column(name = "qrCode")
    private String qrCode;

    @Column(name = "ip")
    private String ip;

    @ManyToOne
    @JoinColumn(name = "fkSala", referencedColumnName = "idSala")
    private Room room;

    @OneToMany(mappedBy = "clnBox")
    private List<Equipment> equipment = new ArrayList();

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Integer getIdCLNBox() {
        return idCLNBox;
    }

    public void setIdCLNBox(Integer idCLNBox) {
        this.idCLNBox = idCLNBox;
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
}