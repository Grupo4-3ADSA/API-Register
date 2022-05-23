package com.autog.register.service;

import com.autog.register.dto.response.FormattedReport;
import com.autog.register.dto.response.MonthlyConsumption;
import com.autog.register.entity.ListaObj;
import com.autog.register.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//@Service
@RestController
@RequestMapping("/relatorio")
public class FormattedReportCsvService {

    @Autowired
    private CompanyRepository repository;

    @GetMapping("/corpodois/{idPredio}")
    public ResponseEntity geracaoRelatorioCsv(@PathVariable int idPredio) {

        String relatorio = "";

        try {
            if (!(repository.existsById(idPredio))) {
                FormattedReport corpo1 = repository.corpoUm(idPredio);

                relatorio += String.format("%s;%s;Bandeira - %s\n\n", "AUTG", "05/2022", "Amarela");

                relatorio += String.format("%s;%s;%s\n", "Nome responsavel", "Razao Social", "CNPJ");
                relatorio += String.format("%s;%s;%s\n\n", corpo1.getNameManager(), corpo1.getCorporateName(),
                        corpo1.getCnpj());

                relatorio += String.format("%s;%s;%s;%s\n", "Nome do predio", "Logradouro", "Numero", "CEP");
                relatorio += String.format("%s;%s;%d;%s\n\n", corpo1.getNameBuilding(), corpo1.getPublicPlace(),
                        corpo1.getNumber(), corpo1.getCep());

                List<MonthlyConsumption> listaLength = repository.corpoDois(idPredio);
                if (!(listaLength.isEmpty())) {
                ListaObj<MonthlyConsumption> corpo2 = new ListaObj<>(listaLength.size());
                    for (MonthlyConsumption mc : listaLength) {
                        corpo2.adiciona(mc);
                    }

                    relatorio += String.format("%s;%s;%s;%s\n", "Sala", "Andar", "Consumo kwm", "Preco");
                    for (int i = 0; i < corpo2.getTamanho(); i++) {
                        MonthlyConsumption mc = corpo2.getElemento(i);
                        relatorio += String.format("%s;%d;\n", mc.getName(), mc.getFloor());
                    }

                    relatorio += String.format("\n%s;%s\n", "Resumo", "R$");
                    relatorio += String.format("%s\n", "Total - kwm:");
                    relatorio += String.format("%s\n", "Total - R$:");
                } else {
                    // Lista vázia
                    return ResponseEntity.status(204).build();
                }

            } else {
                // Id inexistente
                return ResponseEntity.status(404).build();
            }
        } catch (Exception erro) {
            System.out.println("Erro ao puxar os dados do servidor: " + erro);
        }

        return ResponseEntity
                .status(200)
                .header("content-type", "application/csv")
                .header("content-disposition", "filename=\"relatorio-AUTG-CLN.csv\"")
                .body(relatorio);
    }


}
