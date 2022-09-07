package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Predio")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPredio")
    private Integer idBuilding;

    @Column(name = "nome")
    private String nameBuilding;

    @ManyToOne
    @JoinColumn(name = "fkEmpresa", referencedColumnName = "idEmpresa")
    private Company company;

    @OneToOne(mappedBy = "building")
    private Address address;

    @OneToMany(mappedBy = "building")
    private List<Room> rooms = new ArrayList();

//    @OneToMany(mappedBy = "building")
//    private List<Report> report = new ArrayList();
//
//    public List<Report> getReport() {
//        return report;
//    }
//
//    public void setReport(List<Report> report) {
//        this.report = report;
//    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

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

    public String getNameBuilding() {
        return nameBuilding;
    }

    public void setNameBuilding(String nameBuilding) {
        this.nameBuilding = this.nameBuilding;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
