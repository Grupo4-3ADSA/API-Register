package com.autog.register.controller;

import com.autog.register.dto.request.EquipmentRelatorio;
import com.autog.register.dto.request.EquipmentRequest;
import com.autog.register.entity.Equipment;
import com.autog.register.repository.BuildingRepository;
import com.autog.register.repository.CompanyRepository;
import com.autog.register.repository.ManagerRepository;
import com.autog.register.repository.RegisterRepository;
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

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @PostMapping
    public ResponseEntity registerEquipment(@RequestBody @Valid Equipment newEquipment) {
        return service.registerEquipment(newEquipment);
    }

    @GetMapping
    public ResponseEntity getEquipment() {
        return service.getEquipment();
    }

    @GetMapping("/{idEquipment}")
    public ResponseEntity getEquipmentByEquipment(@PathVariable Integer idEquipment) {
        return service.getEquipmentByEquipment(idEquipment);
    }

    @PatchMapping("/{id}")
    public ResponseEntity editEquipment(@PathVariable Integer id, @RequestBody @Valid EquipmentRequest request) {
        return service.editEquipment(id, request);
    }

    @PostMapping("/corpodois/")
    public ResponseEntity geracaoRelatorioCsv(@RequestBody EquipmentRelatorio data) {
        return new FormattedReportCsvService().gravaArquivo(data, repository, registerRepository, buildingRepository);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEquipmentById(@PathVariable Integer id) {
        return service.deleteEquipmentById(id);
    }
}
