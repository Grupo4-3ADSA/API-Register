package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Predio")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPredio")
    private Integer idBuilding;

    @NotBlank
    @Column(name = "nome")
    private String name;

    @ManyToOne
    @JoinColumn(name = "fkEmpresa", referencedColumnName = "idEmpresa")
    private Company company;

    @OneToOne(mappedBy = "building")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(Integer idBuilding) {
        this.idBuilding = idBuilding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
