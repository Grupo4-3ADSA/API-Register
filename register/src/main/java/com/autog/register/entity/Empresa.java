package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpresa")
    private Integer idEmpresa;

    @NotBlank
    @Column(name = "razaoSocial")
    private String razãoSocial;

    @NotBlank
    @Column(name = "cnpj")
    private String cnpj;

    @NotBlank
    @Column(name = "telefone")
    private String telefone;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "dataAbertura")
    private LocalDate dataAbertura;

    @NotNull
    @Column(name = "ativa")
    private Boolean ativa;

    @OneToMany(mappedBy = "Empresa")
    private List<Predio> predios = new ArrayList();

    @OneToMany(mappedBy = "Empresa")
    private List<Gestor> gestores = new ArrayList();
}
