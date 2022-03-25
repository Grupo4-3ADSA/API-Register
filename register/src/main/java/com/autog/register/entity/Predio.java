package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "Predio")
    private List<Sala> salas = new ArrayList();

    @OneToOne(mappedBy = "Predio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Endereco endereco;
}
