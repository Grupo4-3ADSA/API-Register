package com.autog.register.service;

import com.autog.register.entity.RateValue;
import com.autog.register.repository.RateValueRepository;
import com.autog.register.rest.setoreletrico.ClassificacaoValorTarifa;
import com.autog.register.rest.setoreletrico.SetorEletricoBandeiraCliente;
import com.autog.register.rest.setoreletrico.SetorEletricoResposta;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateValueService {

    @Autowired
    private SetorEletricoBandeiraCliente clienteSetorEletrico;

    @Autowired
    private RateValueRepository rateValueRepository;

    public void valorTarifaMesAtual() throws FeignException {

        // Nessa classe precisa de um timer para atualizar de mês em mês
        // a tabela ValorTarifa adicionando a tarifa/bandeira atual daquele mês.

        SetorEletricoResposta seer = clienteSetorEletrico.getBandeira();

        RateValue rv = new RateValue();
        Integer bandeira = seer.getBody().getItems().get(0).getFlagType();

        ClassificacaoValorTarifa clt = ClassificacaoValorTarifa.classificacao(bandeira);

        rv.setFlag(clt.getBandeira());
        rv.setRateValue(clt.getTarifa());
        rv.setDate(seer.getBody().getItems().get(0).getMonth());
        rateValueRepository.save(rv);
    }
}
