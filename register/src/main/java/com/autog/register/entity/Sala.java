package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSala")
    private Integer idSala;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "andar")
    private String andar;

    @OneToMany
    @JoinColumn(name = "fkPredio")
    private Integer fkPredio;

    @OneToMany(mappedBy = "Predio")
    private List<Equipamento> equipamentos = new ArrayList();
}
