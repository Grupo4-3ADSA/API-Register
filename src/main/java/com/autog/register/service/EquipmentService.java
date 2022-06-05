package com.autog.register.service;

import com.autog.register.dto.request.EquipmentRequest;
import com.autog.register.dto.response.EquipmentResponse;
import com.autog.register.entity.Equipment;
import com.autog.register.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository repository;

    public ResponseEntity registerEquipment(Equipment newEquipment) {
        repository.save(newEquipment);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity getEquipment(Integer idCLNBox) {
        List<Object[]> equipments = repository.getEquipmentAndRoomByClnBox(idCLNBox);
        List<EquipmentResponse> equipmentsToBeReturned = new ArrayList<>();
//        List<Equipment> equipments = repository.getEquipmentByClnBox(idCLNBox);

        for(Object[] equip : equipments) {
            equipmentsToBeReturned.add(new EquipmentResponse(
                    (Integer) equip[0],
                    (String) equip[1],
                    (Integer) equip[2],
                    (Integer) equip[3],
                    (String) equip[4],
                    (String) equip[5],
                    ((Date) equip[6]),
                    (Integer) equip[7],
                    (Integer) equip[8],
                    (Integer) equip[9],
                    (Integer) equip[10]
            ));
        }

        if (equipmentsToBeReturned.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(equipmentsToBeReturned);
    }

    public ResponseEntity getEquipmentByEquipment(Integer idEquipment){
        List<Equipment> equipments = repository.getEquip(idEquipment);
        return ResponseEntity.ok(equipments);
    }

    public ResponseEntity listAllEquips(){
        List<Object[]> equipments = repository.getAllEquipments();
        List<EquipmentResponse> equipmentsToBeReturned = new ArrayList<>();

        for(Object[] equip : equipments) {
            equipmentsToBeReturned.add(new EquipmentResponse(
                    (Integer) equip[0],
                    (String) equip[1],
                    (Integer) equip[2],
                    (Integer) equip[3],
                    (String) equip[4],
                    (String) equip[5],
                    ((Date) equip[6]),
                    (Integer) equip[7],
                    (Integer) equip[8],
                    (Integer) equip[9],
                    (Integer) equip[10]
            ));
        }

        if (equipmentsToBeReturned.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(equipmentsToBeReturned);
    }

    private LocalDate convertStringToLocalDate(String dateToBeFormatted) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale( Locale.US );
        LocalDate date = LocalDate.parse(dateToBeFormatted, formatter);
        return date;
    }

    public ResponseEntity editEquipment(Integer id, EquipmentRequest request) {
        if (repository.existsById(id)) {
            repository.updateEquipment(id, request.getName());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity deleteEquipmentById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteEquipment(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
