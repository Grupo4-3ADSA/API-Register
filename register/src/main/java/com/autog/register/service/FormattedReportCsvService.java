package com.autog.register.service;

import com.autog.register.dto.request.EquipmentRelatorio;
import com.autog.register.dto.response.FormattedReport;
import com.autog.register.dto.response.MonthlyConsumption;
import com.autog.register.entity.ListaObj;
import com.autog.register.entity.Register;
import com.autog.register.repository.CompanyRepository;
import com.autog.register.repository.RegisterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;
import java.util.Date;


import static org.springframework.http.ResponseEntity.status;

@Service
public class FormattedReportCsvService {

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


    public ResponseEntity gravaArquivo(EquipmentRelatorio data, CompanyRepository repository,
                                       RegisterRepository registerRepository){

        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;
        long setTotalHoras = totalLampadaLigada(data, registerRepository);
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
            FormattedReport corpo1 = repository.corpoUm(data.getIdPredio());
            saida.format("%s;%s; Bandeira - \n\n", "05/2022", "Amarela");

            saida.format("%s;%s;%s\n", "Nome responsavel", "Razao Social", "CNPJ");
            saida.format("%s;%s;%s\n\n", corpo1.getNameManager(), corpo1.getCorporateName(),
                    corpo1.getCnpj());

            saida.format("%s;%s;%s;%s\n", "Nome do predio", "Logradouro", "Numero", "CEP");
            saida.format("%s;%s;%d;%s\n\n", corpo1.getNameBuilding(), corpo1.getPublicPlace(),
                    corpo1.getNumber(), corpo1.getCep());

            List<MonthlyConsumption> listaLength = repository.corpoDois(data.getIdPredio());
            ListaObj<MonthlyConsumption> corpo2 = new ListaObj<>(listaLength.size());

            for (MonthlyConsumption mc : listaLength) {
                corpo2.adiciona(mc);
            }

            saida.format("%s;%s;%s;%s\n", "Sala", "Andar", "Consumo kwm", "Preco");
            for (int i = 0; i < corpo2.getTamanho(); i++) {
                MonthlyConsumption mc = corpo2.getElemento(i);
                mc.setConsumoKwm(setTotalHoras * 500);
                saida.format("%s;%d;%d;%.2f\n", mc.getName(), mc.getFloor(), mc.getConsumoKwm(),mc.getPreco());
            }
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

        return status(201).build();
    }

    public long totalLampadaLigada(EquipmentRelatorio data, RegisterRepository registerRepository){
        long totalHoras = 0;
        LocalDateTime d1 = null;
        LocalDateTime d2 = null;
        List<Register> lista = registerRepository.findByDateBetween(
                LocalDateTime.of(data.getDataInicio().getYear(), data.getDataInicio().getMonth(), 01, 00, 00),
                LocalDateTime.of(data.getDataFim().getYear(), data.getDataFim().getMonth(), 30, 00, 00));
        if (!lista.isEmpty()) {

            for (int i = 0; i < lista.size(); i++) {

                if (lista.get(i).isOn() && lista.get(i).getEquipment().getIdEquipment() == data.getFkEquipamento()) {
                    d1 = LocalDateTime.of(lista.get(i).getDate().getYear(), lista.get(i).getDate().getMonth(), lista.get(i).getDate().getDayOfMonth(), lista.get(i).getDate().getHour(), lista.get(i).getDate().getMinute());
                }else if (lista.get(i).getEquipment().getIdEquipment() == data.getFkEquipamento()){
                    d2 = LocalDateTime.of(lista.get(i).getDate().getYear(), lista.get(i).getDate().getMonth(), lista.get(i).getDate().getDayOfMonth(), lista.get(i).getDate().getHour(), lista.get(i).getDate().getMinute());
                }

                if (d1 != null && d2 != null) {
                    long diferenca = ChronoUnit.HOURS.between(d1,d2);
                    //long diferenca = Duration.between(d1,d2);
                    totalHoras += diferenca;
                    d1 = null;
                    d2 = null;
                }
            }
        }

        return totalHoras;
    }

}
