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

//    @OneToOne(mappedBy = "building")
//    private Address address;

//    @OneToMany(mappedBy = "building")
//    private List<Room> rooms = new ArrayList();

//    public List<Room> getRooms() {
//        return rooms;
//    }
//
//    public void setRooms(List<Room> rooms) {
//        this.rooms = rooms;
//    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

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
}
