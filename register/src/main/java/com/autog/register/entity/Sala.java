package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSala")
    private Integer idSala;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "andar")
    private String andar;

   // @OneToMany
    //@JoinColumn(name = "fkPredio")
    private Integer fkPredio;

    //@OneToMany(mappedBy = "Predio")
    //private List<Equipamento> equipamentos = new ArrayList();

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public Integer getFkPredio() {
        return fkPredio;
    }

    public void setFkPredio(Integer fkPredio) {
        this.fkPredio = fkPredio;
    }

   // public List<Equipamento> getEquipamentos() {
   //     return equipamentos;
   // }

   // public void setEquipamentos(List<Equipamento> equipamentos) {
    //    this.equipamentos = equipamentos;
    //}
}
