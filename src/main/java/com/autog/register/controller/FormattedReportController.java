package com.autog.register.controller;

import com.autog.register.dto.request.EquipmentRelatorio;
import com.autog.register.repository.*;
import com.autog.register.service.FormattedReportService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/reports")
public class FormattedReportController {

    @Autowired
    private RateValueRepository rateValueRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private RegisterRepository registerRepository;



    @PostMapping("/csv")
    public ResponseEntity geracaoRelatorioCsv(@RequestBody EquipmentRelatorio data) {
        return new FormattedReportService().geracaoRelatorioCsv(data, repository, registerRepository, buildingRepository,
                rateValueRepository);
    }

    @PostMapping("/txt")
    public ResponseEntity geracaoRelatorioTxt(@RequestBody EquipmentRelatorio data) {
        return new FormattedReportService().geracaoRelatorioTxt(data, repository, registerRepository, buildingRepository,
                rateValueRepository);
    }

    @CrossOrigin(value = {"*"}, exposedHeaders = {"Content-Disposition"})
    @PostMapping(value = "/importacao/{idPredio}")
    public ResponseEntity importacaoTxt(@PathVariable int idPredio,
                                        @NotNull @RequestParam("file") MultipartFile file) throws IOException{
        return new FormattedReportService().importacaoTxt(idPredio, file, repository, buildingRepository, reportRepository);
    }

}
