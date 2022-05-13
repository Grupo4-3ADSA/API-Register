package com.autog.register.service;

import com.autog.register.entity.RateValue;
import com.autog.register.repository.CompanyRepository;
import com.autog.register.repository.RateValueRepository;
import com.autog.register.rest.setoreletrico.SetorEletricoBandeiraCliente;
import com.autog.register.rest.setoreletrico.SetorEletricoResposta;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.status;

//@Service
@RestController
@RequestMapping("/setoreletrico")
public class FormattedReportCsvService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private SetorEletricoBandeiraCliente clienteSetorEletrico;

    @Autowired
    private RateValueRepository rateValueRepository;

    @GetMapping
    public ResponseEntity getApi() {

        SetorEletricoResposta seer = null;

        try {
            seer = clienteSetorEletrico.getBandeira();
        } catch (FeignException fe) {
            return status(503).body("Deu ruim");
        }

        RateValue rv = new RateValue();
        Integer bandeira = seer.getBody().getItems().get(0).getFlagType();
        switch (bandeira) {
            case 0:
                rv.setFlag("Verde");
                rv.setRateValue(0.0);
                break;
            case 1:
                rv.setFlag("Amarela");
                rv.setRateValue(1.87);
                break;
            case 2:
                rv.setFlag("Vermelha - Patamar 1");
                rv.setRateValue(3.97);
                break;
            case 3:
                rv.setFlag("Vermelha - Patamar 2");
                rv.setRateValue(9.49);
                break;
            case 4:
                rv.setFlag("Escassez Hídrica");
                rv.setRateValue(14.20);
                break;

        }
        rv.setDate(seer.getBody().getItems().get(0).getMonth());
        rateValueRepository.save(rv);
        return ResponseEntity.status(200).body(seer);
    }

//    @GetMapping
//    public ResponseEntity geracaoRelatorioCsv(@PathVariable int idEmpresa,
//                                              @PathVariable int idPredio,
//                                              @PathVariable int mes,
//                                              @PathVariable int ano) {
////        ListaObj<FormattedReport> lista = repository.
//        return null;
//    }

//    @GetMapping
//    public ResponseEntity geracaoRelatorioCsv(@PathVariable int idPredio) {
//        ListaObj<FormattedReport> lista = repository.corpoUm(idPredio);
//        return null;
//    }

//    public static void gravaArquivoCsv(ListaObj<FormattedReport> lista, String nomeArq) {
//        FileWriter arq = null;  // obj representa o arquivo a ser gravado
//        Formatter saida = null; // obj que usaremos para escrever no arquivo
//        Boolean deuRuim = false;
//        nomeArq += ".csv";      // acrescenta a extensão .csv ao nome do arquivo
//
//        // Bloco try catch para abrir o arquivo
//        try {
//            arq = new FileWriter(nomeArq);
//            saida = new Formatter(arq);
//        }
//        catch (IOException erro) {
//            System.out.println("Erro ao abrir o arquivo");
//            System.exit(1);
//        }
//
//        // Bloco try catch para gravar o arquivo
//        try {
//            // Percorro a lista de cachorros
//            for (int i = 0; i < lista.getTamanho(); i++) {
//                // Obtenho um objeto da lista por vez (índice i)
//                Cachorro dog = lista.getElemento(i);
//                // Grava um registro com as informações do objeto dog
//                // Delimito cada campo com ; pois é um arquivo CSV
//                saida.format("%d;%s;%s;%.2f\n",dog.getId(),dog.getNome(),
//                        dog.getPorte(),dog.getPeso());
//            }
//        }
//        catch (FormatterClosedException erro) {
//            System.out.println("Erro ao gravar o arquivo");
//            deuRuim = true;
//        }
//        finally {
//            saida.close();
//            try {
//                arq.close();
//            }
//            catch (IOException erro) {
//                System.out.println("Erro ao fechar o arquivo");
//                deuRuim = true;
//            }
//            if (deuRuim) {
//                System.exit(1);
//            }
//        }
//    }
//
//    public static void leExibeArquivoCsv(String nomeArq) {
//        FileReader arq = null;  // obj que representa o arquivo para leitura
//        Scanner entrada = null; // obj que será usado para ler do arquivo
//        Boolean deuRuim = false;
//        nomeArq += ".csv";      // acrescento a extensão .csv ao nome do arquivo
//
//        // Bloco try catch para abrir o arquivo
//        try {
//            arq = new FileReader(nomeArq);
//            // defino que o delimitador de campo na leitura será o ; ou o \n (final do registro)
//            entrada= new Scanner(arq).useDelimiter(";|\\n");
//        }
//        catch (FileNotFoundException erro) {
//            System.out.println("Arquivo não encontrado!");
//            System.exit(1);
//        }
//
//        // Bloco try catch para ler o arquivo
//        try {
//            // Exibe uma linha com os títulos das colunas
//            System.out.printf("%4s %-15s %-9s %5s\n","ID","NOME","PORTE","PESO");
//            while (entrada.hasNext()) {   // enquanto não chega ao final do arquivo
//                // Leio o valor de cada campo, como quando leio do teclado usando Scanner
//                Integer id = entrada.nextInt();
//                String nome = entrada.next();   // aqui o next lê a String delimitada por ; então lê até qdo tem nomes separados por branco
//                String porte = entrada.next();
//                Double peso = entrada.nextDouble();
//                // Exibe os dados em formato de colunas
//                System.out.printf("%4d %-15s %-9s %05.2f\n",id,nome,porte,peso);
//            }
//        }
//        catch (NoSuchElementException erro) {
//            System.out.println("Arquivo com problemas");
//            deuRuim = true;
//        }
//        catch (IllegalStateException erro) {
//            System.out.println("Erro na leitura do arquivo");
//            deuRuim = true;
//        }
//        finally {
//            entrada.close();
//            try {
//                arq.close();
//            }
//            catch (IOException erro) {
//                System.out.println("Erro ao fechar o arquivo");
//                deuRuim = true;
//            }
//            if (deuRuim) {
//                System.exit(1);
//            }
//        }
//
//
//    }

}
