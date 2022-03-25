package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    @OneToMany
    @JoinColumn(name = "fkEmpresa")
    private Integer fkEmpresa;

}
