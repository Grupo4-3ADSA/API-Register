package com.autog.register.entity;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Empresa")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpresa")
    private Integer idCompany;

    @NotBlank
    @Column(name = "razaoSocial")
    private String corporateName;

    @NotBlank
    @CNPJ
    @Column(name = "cnpj")
    private String cnpj;

    @NotBlank
    @Column(name = "telefone")
    private String telephone;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "dataAbertura")
    private LocalDate openingDate;

    @NotNull
    @Column(name = "ativa")
    private Boolean active;

    @OneToMany(mappedBy = "company")
    private List<Building> buildings = new ArrayList();

  //  @OneToMany(mappedBy = "company")
  //  private List<Manager> managers = new ArrayList();

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Entity
    @Table(name = "Predio")
    public static class Building {
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

    @Entity
    @Table(name = "Endereco")
    public static class Address {

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

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "fkPredio")
        private Building building;

        public Building getBuilding() {
            return building;
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
    }

    @Entity
    @Table(name = "Equipamento")
    public static class Equipment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idEquipamento")
        private Integer idEquipment;

        @NotBlank
        @Column(name = "nome")
        private String name;

        @NotNull
        @Column(name = "instalacao")
        private LocalDate installationDate;

        @Column(name = "vidaUtil")
        private Integer lifespan;

        @ManyToOne
        @JoinColumn(name = "fkSala", referencedColumnName = "idSala")
        private Room room;

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

        public Room getRoom() {
            return room;
        }

        public void setRoom(Room room) {
            this.room = room;
        }
    }

    @Entity
    @Table(name = "Gestor")
    public static class Manager {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idGestor")
        private Integer idManager;

        @NotBlank
        @Column(name = "nome")
        private String name;

        @NotBlank
        @Column(name = "login")
        private String login;

        @NotBlank
        @Column(name = "senha")
        private String password;

        //@ManyToOne
        @JoinColumn(name = "fkEmpresa", referencedColumnName = "idEmpresa")
        private Integer fkEmpresa;
    //    private Company company;

        public Integer getFkCompany() {
            return fkEmpresa;
        }

        public void setFkCompany(Integer fkCompany) {
            this.fkEmpresa = fkCompany;
        }

        public Integer getIdManager() {
            return idManager;
        }

        public void setIdManager(Integer idManager) {
            this.idManager = idManager;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

      //  public Company getCompany() {
      //     return company;
      //  }

       // public void setCompany(Company company) {
        //    this.company = company;
       // }
    }

    @Entity
    @Table(name = "Sala")
    public static class Room {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idSala")
        private Integer idRoom;

        @NotBlank
        @Column(name = "nome")
        private String name;

        @NotNull
        @Column(name = "andar")
        private Integer floor;

        @ManyToOne
        @JoinColumn(name = "fkPredio", referencedColumnName = "idPredio")
        private Building building;

        @OneToMany(mappedBy = "room")
        private List<Equipment> equipment = new ArrayList();


        public Integer getIdRoom() {
            return idRoom;
        }

        public void setIdRoom(Integer idRoom) {
            this.idRoom = idRoom;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getFloor() {
            return floor;
        }

        public void setFloor(Integer floor) {
            this.floor = floor;
        }

        public Building getBuilding() {
            return building;
        }

        public void setBuilding(Building building) {
            this.building = building;
        }
    }
}
