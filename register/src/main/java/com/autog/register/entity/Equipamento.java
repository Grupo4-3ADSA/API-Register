package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipamento")
    private Integer idEquipamento;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "instalacao")
    private LocalDate dataInstalacao;

    @Column(name = "vidaUtil")
    private Integer vidaUtil;

    @OneToMany
    @JoinColumn(name = "fkSala")
    private Integer fkSala;
}
