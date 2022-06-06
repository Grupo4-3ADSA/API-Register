package com.autog.register.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class EquipmentRelatorio {

    private Integer idPredio;
    private Integer fkEquipamento;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public EquipmentRelatorio(Integer idPredio, Integer fkEquipamento, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.idPredio = idPredio;
        this.fkEquipamento = fkEquipamento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public EquipmentRelatorio() {
    }

    public Integer getIdPredio() {
        return idPredio;
    }

    public void setIdPredio(Integer idPredio) {
        this.idPredio = idPredio;
    }

    public Integer getFkEquipamento() {
        return fkEquipamento;
    }

    public void setFkEquipamento(Integer fkEquipamento) {
        this.fkEquipamento = fkEquipamento;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }
}
