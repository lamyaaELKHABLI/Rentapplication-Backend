package com.rentapplication.rentapplication.controllers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.rentapplication.rentapplication.entities.*;
import com.rentapplication.rentapplication.repositories.EquipmentLogementRepository;
import com.rentapplication.rentapplication.repositoryL.EquipmentRepository;
import com.rentapplication.rentapplication.repositories.LogementCategoryRepository;
import com.rentapplication.rentapplication.repositories.LogementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping
public class EquipmentController {
    @Autowired(required = true)
    private EquipmentRepository equipmentrepository;

    @Autowired(required = true)
    private LogementRepository logementrepository;

    @Autowired(required = true)
    private EquipmentLogementRepository equipmentlogementrepository;

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/equipments")
    public List<Equipment> getAllEquipments(){
        return equipmentrepository.findAll();
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/savelogementequipment")
    public EquipmentLogement SaveLogementEquipment (@RequestParam("equipment_id") Integer equipment_id,
                                                   @RequestParam("logement_id") Integer logement_id
    ) throws JsonParseException, JsonMappingException, Exception{
        Logement newlogement = logementrepository.findById(logement_id).orElse(null);
        Equipment newequipment = equipmentrepository.findById(equipment_id).orElse(null);
        EquipmentLogement equipmentlogement = new EquipmentLogement();
        equipmentlogement.setEquipment(newequipment);
        equipmentlogement.setLogement(newlogement);
    return equipmentlogementrepository.save(equipmentlogement);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping(path="/equipments/details/{id}")
    public Equipment getAllEquipementbyID(@PathVariable Integer id){
        return equipmentrepository.findById(id).orElse(null);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping(path="/equipments/{id}")
    public List<EquipmentLogement> getEquipements(@PathVariable("id") Integer id) throws Exception{
        return equipmentlogementrepository.findByLogementId(id);
    }

    @PostMapping(value = "/modifylogementequipment")
    public EquipmentLogement ModifyLogementEquipment (@RequestParam("equipment_id") Integer equipment_id,
                                                      @RequestParam("logement_id") Integer logement_id
    ) throws JsonParseException, JsonMappingException, Exception{
        equipmentlogementrepository.deleteAllByLogementId(logement_id);
        Logement newlogement = logementrepository.findById(logement_id).orElse(null);
        Equipment newequipment = equipmentrepository.findById(equipment_id).orElse(null);
        EquipmentLogement equipmentlogement = new EquipmentLogement();
        equipmentlogement.setEquipment(newequipment);
        equipmentlogement.setLogement(newlogement);
        return equipmentlogementrepository.save(equipmentlogement);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/equipmentsLog/{id}")
    public List<EquipmentLogement> getAllEquipmentsLog(int id){

        return equipmentlogementrepository.findByLogementId(id);
    }

}
