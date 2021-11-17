package com.rentapplication.rentapplication.controllerL;


import com.rentapplication.rentapplication.entities.Logement;
import com.rentapplication.rentapplication.repositoryL.LogementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LogementController {

    @Autowired(required = true)
    private LogementRepository logementrepository;

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/logements")
    public List<Logement> getAllLogement(){
        return logementrepository.findAll();
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/logement")
    public Logement createLogement(@RequestBody Logement logement){
        return logementrepository.save(logement);
    }
}
