package com.rentapplication.rentapplication.controllerL;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.rentapplication.rentapplication.entities.Equipment;
import com.rentapplication.rentapplication.entities.EquipmentLogement;
import com.rentapplication.rentapplication.entities.Logement;
import com.rentapplication.rentapplication.entities.Picture;
import com.rentapplication.rentapplication.repositoryL.EquipmentRepository;
import com.rentapplication.rentapplication.repositoryL.LogementCategoryRepository;
import com.rentapplication.rentapplication.repositoryL.LogementRepository;
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
    private LogementCategoryRepository logementcategoryrepository;

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/equipments")
    public List<Equipment> getAllEquipments(){
        return equipmentrepository.findAll();
    }

   /* @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/savelogementequipment")
    public LogementCategoryRepository SaveLogementEquipment (@RequestParam("equipment_id") Integer equipment_id,
                                @RequestParam("logement_id") Integer logement_id
    ) throws JsonParseException, JsonMappingException, Exception{
        Logement newlogement = logementrepository.findById(logement_id).orElse(null);
        Equipment newequipment = equipmentrepository.findById(equipment_id).orElse(null);
        EquipmentLogement equipmentlogement = new EquipmentLogement();
        equipmentlogement.setEquipment(newequipment);
        equipmentlogement.setLogement(newlogement);
    return logementcategoryrepository.save(equipmentlogement);
    }*/
}
