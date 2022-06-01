package com.autog.register.rest.setoreletrico;

public enum ClassificacaoValorTarifa {

    VERDE(0, "Verde", 0.0),
    AMARELA(1, "Amarela", 1.87),
    VERMELHA_PATAMAR1(2, "Vermelha - Patamar 1", 3.97),
    VERMELHA_PATAMAR2(3, "Vermelha - Patamar 1", 3.97),
    ESCASSEZ_HIDRICA(4, "Escassez Hídrica", 14.20);

    private Integer id;
    private String bandeira;
    private Double tarifa;

    ClassificacaoValorTarifa(Integer id, String bandeira, Double tarifa) {
        this.id = id;
        this.bandeira = bandeira;
        this.tarifa = tarifa;
    }

    public static ClassificacaoValorTarifa classificacao(Integer numero) {
        for (ClassificacaoValorTarifa cvt : values ()) {
            if (numero == cvt.id) {
                return cvt;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getBandeira() {
        return bandeira;
    }

    public Double getTarifa() {
        return tarifa;
    }
}
