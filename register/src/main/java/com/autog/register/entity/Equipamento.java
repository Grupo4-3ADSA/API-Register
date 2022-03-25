package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipamento")
    private Integer idEquipamento;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "instalacao")
    private LocalDate dataInstalacao;

    @Column(name = "vidaUtil")
    private Integer vidaUtil;

    //@OneToMany
    //@JoinColumn(name = "fkSala")
    private Integer fkSala;

    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Integer idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public Integer getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(Integer vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public Integer getFkSala() {
        return fkSala;
    }

    public void setFkSala(Integer fkSala) {
        this.fkSala = fkSala;
    }
}
