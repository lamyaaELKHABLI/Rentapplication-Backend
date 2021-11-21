package com.rentapplication.rentapplication.controllers;

import com.rentapplication.rentapplication.entities.Announcement;
import com.rentapplication.rentapplication.entities.Flatmmate;
import com.rentapplication.rentapplication.repositories.FlatemateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class FlatemmateController {

    @Autowired(required = true)
    private FlatemateRepository  flatemmaterepository;


    @CrossOrigin("http://localhost:4200")
    @GetMapping("/flatemmates/{id}")
    public Flatmmate getFlatemmate(@PathVariable("logement_id") Integer id) throws Exception{
        return (Flatmmate) flatemmaterepository.findByLogementId(id);
    }

}
