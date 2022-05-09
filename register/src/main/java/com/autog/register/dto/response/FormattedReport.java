package com.autog.register.dto.response;

import java.util.List;

public class FormattedReport {

    private String nomeResponsavelEmpresa;
    private String razaoSocialEmpresa;
    private String cnpjEmpresa;
    private Integer nPredio;
    private String nomePredio;
    private String logradouroEndereco;
    private String numeroEndereco;
    private String cepEndereco;
    private List<MonthlyConsumption> consumoMensal;
    private Double totalKwm;
    private Double totalValor;

    public String getNomeResponsavelEmpresa() {
        return nomeResponsavelEmpresa;
    }

    public void setNomeResponsavelEmpresa(String nomeResponsavelEmpresa) {
        this.nomeResponsavelEmpresa = nomeResponsavelEmpresa;
    }

    public String getRazaoSocialEmpresa() {
        return razaoSocialEmpresa;
    }

    public void setRazaoSocialEmpresa(String razaoSocialEmpresa) {
        this.razaoSocialEmpresa = razaoSocialEmpresa;
    }

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public Integer getnPredio() {
        return nPredio;
    }

    public void setnPredio(Integer nPredio) {
        this.nPredio = nPredio;
    }

    public String getNomePredio() {
        return nomePredio;
    }

    public void setNomePredio(String nomePredio) {
        this.nomePredio = nomePredio;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public List<MonthlyConsumption> getConsumoMensal() {
        return consumoMensal;
    }

    public void setConsumoMensal(List<MonthlyConsumption> consumoMensal) {
        this.consumoMensal = consumoMensal;
    }

    public Double getTotalKwm() {
        return totalKwm;
    }

    public void setTotalKwm(Double totalKwm) {
        this.totalKwm = totalKwm;
    }

    public Double getTotalValor() {
        return totalValor;
    }

    public void setTotalValor(Double totalValor) {
        this.totalValor = totalValor;
    }
}
