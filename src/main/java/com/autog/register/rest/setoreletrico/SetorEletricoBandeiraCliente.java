package com.autog.register.rest.setoreletrico;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "way2", url = "https://apise.way2.com.br/v1/bandeiras?apikey=c6c6bfabc795492da4d54833b58ec52b")
public interface SetorEletricoBandeiraCliente {

    @GetMapping
    public SetorEletricoResposta getBandeira();
}
