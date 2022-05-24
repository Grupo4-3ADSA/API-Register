package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Gestor")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGestor")
    private Integer idManager;

    @NotBlank
    @Column(name = "nomeGestor")
    private String nameManager;

    @NotBlank
    @Column(name = "login")
    private String login;

    @NotBlank
    @Column(name = "senha")
    private String password;

    @ManyToOne
    @JoinColumn(name = "fkCompany", referencedColumnName = "idEmpresa")
    private Company company;
//    private Integer fkCompany;

//    public Integer getFkCompany() {
//        return fkCompany;
//    }
//
//    public void setFkCompany(Integer fkCompany) {
//        this.fkCompany = fkCompany;
//    }

    public Integer getIdManager() {
        return idManager;
    }

    public void setIdManager(Integer idManager) {
        this.idManager = idManager;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String name) {
        this.nameManager = nameManager;
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

    public Company getCompany() {
       return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return nameManager;
    }
}
