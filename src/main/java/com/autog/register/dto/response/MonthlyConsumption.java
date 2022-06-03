package com.autog.register.dto.response;

import com.autog.register.service.FormattedReportCsvService;

public class MonthlyConsumption {

    private String name;
    private Integer floor;
    private Double consumoKwm;
    private Double preco;

    public MonthlyConsumption(String name, Integer floor) {
        this.name = name;
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getConsumoKwm() {
        return consumoKwm;
    }

    public void setConsumoKwm(Double consumoKwm) {
        this.consumoKwm = consumoKwm;
    }

    public Double getPreco() {
        setPreco(getConsumoKwm()*0.28738);
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "MonthlyConsumption{" +
                "name='" + name + '\'' +
                ", floor=" + floor +
                '}';
    }
}
