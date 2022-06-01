package com.autog.register.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "Endereco")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEndereco")
    private Integer idAddress;

    @NotBlank
    @Column(name = "logradouro")
    private String publicPlace;

    @NotNull
    @Positive
    @Column(name = "numero")
    private Integer number;

    @NotBlank
    @Column(name = "bairro")
    private String district;

    @NotBlank
    @Column(name = "cidade")
    private String city;

    @NotBlank
    @Column(name = "uf")
    private String state;

    @NotBlank
    @Length(min = 8, max = 8)
    @Column(name = "cep")
    private String cep;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkPredio")
    private Building building;

    public Building getBuilding() {
        return building;
    }

    public String getCep() {
        return cep;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
