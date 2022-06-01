package com.autog.register.dto.response;

import java.util.List;

public class FormattedReport {

    private String nameManager;
    private String corporateName;
    private String cnpj;
    private String nameBuilding;
    private String publicPlace;
    private Integer number;
    private String cep;
//    private Double totalKwm;
//    private Double totalValor;

    public FormattedReport(String nameManager, String corporateName, String cnpj, String nameBuilding, String publicPlace, Integer number, String cep) {
        this.nameManager = nameManager;
        this.corporateName = corporateName;
        this.cnpj = cnpj;
        this.nameBuilding = nameBuilding;
        this.publicPlace = publicPlace;
        this.number = number;
        this.cep = cep;
    }

    public String getNameManager() {
        return nameManager;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNameBuilding() {
        return nameBuilding;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public Integer getNumber() {
        return number;
    }

    public String getCep() {
        return cep;
    }


    //
//    public Double getTotalKwm() {
//        return totalKwm;
//    }
//
//    public void setTotalKwm(Double totalKwm) {
//        this.totalKwm = totalKwm;
//    }
//
//    public Double getTotalValor() {
//        return totalValor;
//    }
//
//    public void setTotalValor(Double totalValor) {
//        this.totalValor = totalValor;
//    }
}
