package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEndereco")
    private Integer idEndereco;

    @NotBlank
    @Column(name = "logradouro")
    private String logradouro;

    @NotNull
    @Column(name = "numero")
    private Integer numero;

    @NotBlank
    @Column(name = "bairro")
    private String bairro;

    @NotBlank
    @Column(name = "cidade")
    private String cidade;

    @NotBlank
    @Column(name = "uf")
    private String uf;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Predio")
    private Predio predio;
}
