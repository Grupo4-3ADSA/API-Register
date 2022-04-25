package com.autog.register.entity;

import javax.persistence.*;

@Entity
@Table(name = "CLNBox")
public class CLNBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCLNBox")
    private Integer idCLNBox;

    @Column(name = "qrCode")
    private String qrCode;

    @Column(name = "ip")
    private String ip;

    @JoinColumn(name = "fkSala", referencedColumnName = "idSala")
    private Integer fkSala;

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

    public Integer getFkSala() {
        return fkSala;
    }

    public void setFkSala(Integer fkSala) {
        this.fkSala = fkSala;
    }
}
