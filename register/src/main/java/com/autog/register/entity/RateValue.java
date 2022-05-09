package com.autog.register.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
@Table(name = "ValorTarifa")
public class RateValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idValorTarifa")
    private Integer idRateValue;

    @NotNull
    @Column(name = "valorTarifa")
    private Double rateValue;

    @Column(name = "bandeira")
    private String flag;

    @PastOrPresent
    @Column(name = "date")
    private LocalDate date;

    public Integer getIdRateValue() {
        return idRateValue;
    }

    public void setIdRateValue(Integer idRateValue) {
        this.idRateValue = idRateValue;
    }

    public Double getRateValue() {
        return rateValue;
    }

    public void setRateValue(Double rateValue) {
        this.rateValue = rateValue;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
