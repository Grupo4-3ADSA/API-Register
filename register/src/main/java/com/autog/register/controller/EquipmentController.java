package com.autog.register.controller;

import com.autog.register.dto.request.EquipmentRequest;
import com.autog.register.entity.Equipment;
import com.autog.register.service.EquipmentService;
import com.autog.register.service.FormattedReportCsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {

    @Autowired
    private EquipmentService service;

    @PostMapping
    public ResponseEntity registerEquipment(@RequestBody @Valid Equipment newEquipment) {
        return service.registerEquipment(newEquipment);
    }

    @GetMapping("/{idCompany}")
    public ResponseEntity getEquipment(@PathVariable Integer idCompany) {
        return service.getEquipment(idCompany);
    }

    @PatchMapping("/{id}")
    public ResponseEntity editEquipment(@PathVariable Integer id, @RequestBody @Valid EquipmentRequest request) {
        return service.editEquipment(id, request);
    }

    @GetMapping("/corpodois/{idPredio}/{fkEquipamento}/{dataInicio}/{dataFim}")
    public ResponseEntity geracaoRelatorioCsv(@PathVariable int idPredio,@PathVariable Integer fkEquipamento,@PathVariable Date dataInicio,@PathVariable Date dataFim) {
        return new FormattedReportCsvService().gravaArquivo(idPredio, fkEquipamento, dataInicio, dataFim);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEquipmentById(@PathVariable Integer id) {
        return service.deleteEquipmentById(id);
    }
}
