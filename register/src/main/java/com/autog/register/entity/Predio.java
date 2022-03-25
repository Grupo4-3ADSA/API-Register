package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Predio")
public class Predio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPredio")
    private Integer idPredio;

    @NotBlank
    @Column(name = "nome")
    private String nome;

   // @OneToMany
   // @JoinColumn(name = "fkEmpresa")
    private Integer fkEmpresa;

   // @OneToMany(mappedBy = "Predio")
   // private List<Sala> salas = new ArrayList();

   // @OneToOne(mappedBy = "Predio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   // private Endereco endereco;

    public Integer getIdPredio() {
        return idPredio;
    }

    public void setIdPredio(Integer idPredio) {
        this.idPredio = idPredio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

   // public List<Sala> getSalas() {
  //      return salas;
   // }

   // public void setSalas(List<Sala> salas) {
   //     this.salas = salas;
   // }

   // public Endereco getEndereco() {
   //     return endereco;
  //  }

   // public void setEndereco(Endereco endereco) {
    //    this.endereco = endereco;
    //}
}
