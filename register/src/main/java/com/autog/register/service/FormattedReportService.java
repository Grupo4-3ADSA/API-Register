package com.autog.register.service;

import com.autog.register.dto.request.*;
import com.autog.register.dto.response.FormattedReport;
import com.autog.register.dto.response.MonthlyConsumption;
import com.autog.register.entity.ListaObj;
import com.autog.register.entity.RateValue;
import com.autog.register.repository.CompanyRepository;
import com.autog.register.repository.RateValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


//@Service
@RestController
@RequestMapping("/relatorio")
public class FormattedReportService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private RateValueRepository rateValueRepository;

    @GetMapping("/csv/{idPredio}")
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


    @GetMapping("/txt/{idPredio}")
    public ResponseEntity geracaoRelatorioTxt(@PathVariable int idPredio) {

        int mes = 5;
        int ano = 2022;
        int contaCorpo = 0;
        String nomeArq = "relatorio.txt";
        InputStreamResource resource = null;

        File file = new File("relatorio.txt");
        file.delete();

        try {
            if (!(repository.existsById(idPredio))) {
                FormattedReport dadosEmpresa = repository.corpoUm(idPredio);
                List<MonthlyConsumption> listaLength = repository.corpoDois(idPredio);
                RateValue rv = rateValueRepository.findByDateBetween(
                        LocalDateTime.of(ano, mes, 01, 00, 00),
                        calculoUltimoDiaMes(mes, ano));

                String header = "00Relatorio_AUTG";
                header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                header += "00";
                gravaRelatorio(header, "relatorio.txt");

                String corpo1 = "02";
                corpo1 += String.format("%-5.5s", "AUTG");
                corpo1 += String.format("%-9.9s", "0" + mes + "/" + ano);
                corpo1 += String.format("%-25.25s", "Bandeira - " + rv.getFlag());
                gravaRelatorio(corpo1, "relatorio.txt");
                contaCorpo++;

                String corpo2 = "03";
                corpo2 += String.format("%-25.25s", dadosEmpresa.getNameManager());
                corpo2 += String.format("%-35.35s", dadosEmpresa.getCorporateName());
                corpo2 += String.format("%-14.14s", dadosEmpresa.getCnpj());
                gravaRelatorio(corpo2, "relatorio.txt");
                contaCorpo++;

                String corpo3 = "04";
                corpo3 += String.format("%-25.25s", dadosEmpresa.getNameBuilding());
                corpo3 += String.format("%-35.35s", dadosEmpresa.getPublicPlace());
                corpo3 += String.format("%05d", dadosEmpresa.getNumber());
                corpo3 += String.format("%-8.8s", dadosEmpresa.getCep());
                gravaRelatorio(corpo3, "relatorio.txt");
                contaCorpo++;

                if (!(listaLength.isEmpty())) {
                    ListaObj<MonthlyConsumption> dadosSala = new ListaObj<>(listaLength.size());
                    for (MonthlyConsumption mc : listaLength) {
                        dadosSala.adiciona(mc);
                    }

                    String corpo4;
                    Double totalKwm = 0.0;
                    Double totalReais = 0.0;
                    for (int i = 0; i < dadosSala.getTamanho(); i++) {
                        corpo4 = "05";
                        Double consumoKwm = ThreadLocalRandom.current().nextDouble(1, 99999.99);
                        Double consumoReais = ThreadLocalRandom.current().nextDouble(1, 99999.99);

                        MonthlyConsumption mc = dadosSala.getElemento(i);
                        corpo4 += String.format("%-25.25s", mc.getName());
                        corpo4 += String.format("%03d", mc.getFloor());
                        corpo4 += String.format("%012.2f", consumoKwm);
                        corpo4 += String.format("%012.2f", consumoReais);
                        totalKwm += consumoKwm;
                        totalReais += consumoReais;
                        contaCorpo++;
                        gravaRelatorio(corpo4, "relatorio.txt");
                    }

                    String corpo5 = "06";
                    corpo5 += String.format("%012.2f", totalKwm);
                    corpo5 += String.format("%012.2f", totalReais);
                    gravaRelatorio(corpo5, "relatorio.txt");
                    contaCorpo++;

                    String trailer = "01";
                    trailer += String.format("%07d", contaCorpo);
                    gravaRelatorio(trailer, nomeArq);

                    resource = new InputStreamResource(new FileInputStream(new File("relatorio.txt")));

//                corpo += String.format("\n%-25.25s%-35.35s%-15.15s\n", "Nome responsável", "Razão Social", "CNPJ");
//                corpo += String.format("\n%-25.25s%-35.35s%-7.7s%-9.9s\n", "Nome do prédio", "Logradouro", "Número", "CEP");
//                corpo += String.format("\n%-25.25s%-10.10s%-15.15s%-15.15s\n", "Sala", "Andar", "Consumo kwm", "Preco");
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
                .header("content-type", "application/txt")
                .header("content-disposition", "filename=\"relatorio-AUTG-CLN.txt\"")
                .body(resource);
    }

    public LocalDateTime calculoUltimoDiaMes(int mes, int ano) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.MONTH, mes - 1);
        int dias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return LocalDateTime.of(ano, mes, dias, 00, 00);
    }

    public static void gravaRelatorio(String registro, String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException ex) {
            System.out.println("Erro ao abrir o arquivo: " + ex);
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException ex) {
            System.out.println("Erro ao gravar o arquivo: " + ex);
        }
    }

    public static void lerArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String empresaPrestadora, dataRelatorio, bandeira, gestorResponsavel, razaoSocial,
                cnpj, nomeEdificio, logradouro, cep, sala;
        Integer numero, andar;
        Double consumoKwm, consumoReais, totalKwm, totalReais;

        int contaRegCorpoLido = 0;
        int qtdRegCorpoGravado;

        ReportInfoRequest rir = null;
        ReportCompanyRequest rcr = null;
        ReportAddressRequest rar = null;
        ReportConsumptionRequest rcnr = null;
        List<ReportMonthlyConsumptionRequest> listaConsumo = new ArrayList<>();

        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException ex) {
            System.out.println("Erro ao abrir o arquivo: " + ex);
        }

        try {
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("É um registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 16));
                    System.out.println("Data e hora gravação: " + registro.substring(16, 35));
                    System.out.println("Versão do documento: " + registro.substring(35, 37));
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("É um registro de trailer");
                    qtdRegCorpoGravado = Integer.parseInt(registro.substring(2, 9));
                    if (contaRegCorpoLido == qtdRegCorpoGravado) {
                        System.out.println("Quantidade de registros lidos são compatíveis com a " +
                                "quantidade de registros gravados");
                    } else {
                        System.out.println("Quantidade de registros lidos não são compatíveis com a " +
                                "quantidade de registros gravados");
                    }
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("É um registro de corpo 1 - Informações do relatório");
                    empresaPrestadora = registro.substring(02, 7).trim();
                    dataRelatorio = registro.substring(07, 15).trim();
                    bandeira = registro.substring(15, 35).trim();
                    contaRegCorpoLido++;

                    rir = new ReportInfoRequest(empresaPrestadora, dataRelatorio, bandeira);
                } else if (tipoRegistro.equals("03")) {
                    System.out.println("É um registro de corpo 2 - Informações da empresa contratante");
                    gestorResponsavel = registro.substring(02, 27).trim();
                    razaoSocial = registro.substring(27, 62).trim();
                    cnpj = registro.substring(62, 76).trim();
                    contaRegCorpoLido++;

                    rcr = new ReportCompanyRequest(gestorResponsavel, razaoSocial, cnpj);
                } else if (tipoRegistro.equals("04")) {
                    System.out.println("É um registro de corpo 3 - Informações da localidade do edifício");
                    nomeEdificio = registro.substring(02, 27).trim();
                    logradouro = registro.substring(27, 62).trim();
                    numero = Integer.valueOf(registro.substring(62, 67));
                    cep = registro.substring(67, 75).trim();
                    contaRegCorpoLido++;

                    rar = new ReportAddressRequest(nomeEdificio, logradouro, numero, cep);

                } else if (tipoRegistro.equals("05")) {
                    System.out.println("É um registro de corpo 4 - Informações de consumo");
                    sala = registro.substring(02, 27).trim();
                    andar = Integer.valueOf(registro.substring(27, 30));
                    consumoKwm = Double.valueOf(registro.substring(30, 42).replace(',', '.'));
                    consumoReais = Double.valueOf(registro.substring(42, 54).replace(',', '.'));
                    contaRegCorpoLido++;

                    ReportMonthlyConsumptionRequest rmcr = new ReportMonthlyConsumptionRequest(sala, andar, consumoKwm, consumoReais);
                    listaConsumo.add(rmcr);
                } else if (tipoRegistro.equals("06")) {
                    System.out.println("É um registro de corpo 5 - Total de consumo kwm e em reais");
                    totalKwm = Double.valueOf(registro.substring(02,14).replace(',', '.'));
                    totalReais = Double.valueOf(registro.substring(14,26).replace(',', '.'));
                    contaRegCorpoLido++;

                    rcnr = new ReportConsumptionRequest(totalKwm, totalReais);
                } else {
                    System.out.println("Tipo de registro inválido!");
                }

                registro = entrada.readLine();
            }

            entrada.close();

        } catch (IOException ex) {
            System.out.println("Erro ao abrir o arquivo: " + ex);
        }

        System.out.println("\nConteúdo importado:");
        System.out.println(rir);
        System.out.println(rcr);
        System.out.println(rar);
        for (ReportMonthlyConsumptionRequest rmcr : listaConsumo) {
            System.out.println(rmcr);
        }
        System.out.println(rcnr);
    }

    public static void main(String[] args) {
        lerArquivoTxt("relatorio.txt");
    }
}
