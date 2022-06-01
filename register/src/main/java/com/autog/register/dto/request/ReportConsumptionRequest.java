package com.autog.register.dto.request;

public class ReportConsumptionRequest {

    private Double totalKwm;
    private Double totalReais;

    public ReportConsumptionRequest(Double totalKwm, Double totalReais) {
        this.totalKwm = totalKwm;
        this.totalReais = totalReais;
    }

    public Double getTotalKwm() {
        return totalKwm;
    }

    public void setTotalKwm(Double totalKwm) {
        this.totalKwm = totalKwm;
    }

    public Double getTotalReais() {
        return totalReais;
    }

    public void setTotalReais(Double totalReais) {
        this.totalReais = totalReais;
    }

    @Override
    public String toString() {
        return "ReportConsumptionRequest{" +
                "totalKwm=" + totalKwm +
                ", totalReais=" + totalReais +
                '}';
    }
}
