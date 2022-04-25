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
