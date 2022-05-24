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

    @NotNull
    @Column(name = "qtdEquipamento")
    private Integer qtdEquipment;

    @NotNull
    @Column(name = "porta")
    private Integer door;

    @ManyToOne
    @JoinColumn(name = "idCLNBox", referencedColumnName = "idCLNBox")
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

}
