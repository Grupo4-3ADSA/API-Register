package com.autog.register.service;

import com.autog.register.dto.response.FormattedReport;
import com.autog.register.dto.response.MonthlyConsumption;
import com.autog.register.entity.ListaObj;
import com.autog.register.entity.RateValue;
import com.autog.register.repository.CompanyRepository;
import com.autog.register.repository.RateValueRepository;
import com.autog.register.rest.setoreletrico.SetorEletricoBandeiraCliente;
import com.autog.register.rest.setoreletrico.SetorEletricoResposta;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

//@Service
@RestController
@RequestMapping("/relatorio")
public class FormattedReportCsvService {

    @Autowired
    private CompanyRepository repository;

//    @GetMapping("/corpoum/{idPredio}")
//    public ResponseEntity geracaoRelatorioCsv1(@PathVariable int idPredio) {
//        FormattedReport corpo = repository.corpoUm(idPredio);
//        return ResponseEntity.ok(corpo);
//    }
//
//    @GetMapping("/corpodois/{idPredio}")
//    public ResponseEntity geracaoRelatorioCsv2(@PathVariable int idPredio) {
//        List<MonthlyConsumption> corpo = repository.corpoDois(idPredio);
//        return ResponseEntity.ok(corpo);
//    }
//
//    @GetMapping
//    public ResponseEntity geracaoRelatorioCsv3(@PathVariable int idPredio) {
////        ListaObj<FormattedReport> lista = repository.
//        return null;
//    }

    @GetMapping("/corpodois/{idPredio}")
    public ResponseEntity geracaoRelatorioCsv(@PathVariable int idPredio) {

        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;
        String nomeArq = "relatorio.csv";

        // Bloco try catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // Bloco try catch para gravar o arquivo
        try {
            FormattedReport corpo1 = repository.corpoUm(idPredio);
            saida.format("%s;%s;Bandeira - %s\n\n", "AUTG","05/2022", "Amarela");

            saida.format("%s;%s;%s\n", "Nome responsavel", "Razao Social", "CNPJ");
            saida.format("%s;%s;%s\n\n", corpo1.getNameManager(), corpo1.getCorporateName(),
                    corpo1.getCnpj());

            saida.format("%s;%s;%s;%s\n", "Nome do predio", "Logradouro", "Numero", "CEP");
            saida.format("%s;%s;%d;%s\n\n", corpo1.getNameBuilding(), corpo1.getPublicPlace(),
                    corpo1.getNumber(), corpo1.getCep());

            List<MonthlyConsumption> listaLength = repository.corpoDois(idPredio);
            ListaObj<MonthlyConsumption> corpo2 = new ListaObj<>(listaLength.size());

            for (MonthlyConsumption mc : listaLength) {
                corpo2.adiciona(mc);
            }

            saida.format("%s;%s;%s;%s\n", "Sala", "Andar", "Consumo kwm", "Preco");
            for (int i = 0; i < corpo2.getTamanho(); i++) {
                MonthlyConsumption mc = corpo2.getElemento(i);
                saida.format("%s;%d;\n", mc.getName(), mc.getFloor());
            }

            saida.format("\n%s;%s\n", "Resumo", "R$");
            saida.format("%s\n", "Total - kwm:");
            saida.format("%s\n", "Total - R$:");
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }

        return status(200).build();
    }


}