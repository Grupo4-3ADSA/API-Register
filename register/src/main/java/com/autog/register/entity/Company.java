package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

   // @OneToMany(mappedBy = "Empresa")
   // private List<Predio> predios = new ArrayList();

   // @OneToMany(mappedBy = "Empresa")
   // private List<Gestor> gestores = new ArrayList();

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

   // public List<Predio> getPredios() {
   //     return predios;
    //}

   // public void setPredios(List<Predio> predios) {
   //     this.predios = predios;
   // }

  //  public List<Gestor> getGestores() {
   //     return gestores;
   // }

   // public void setGestores(List<Gestor> gestores) {
    //    this.gestores = gestores;
   // }
}
