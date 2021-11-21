package com.rentapplication.rentapplication.controllers;


import com.rentapplication.rentapplication.entities.Announcement;
import com.rentapplication.rentapplication.entities.Logement;
import com.rentapplication.rentapplication.entities.User;
import com.rentapplication.rentapplication.repositories.AnnouncementRepository;
import com.rentapplication.rentapplication.repositories.LogementRepository;
import com.rentapplication.rentapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LogementController {

    @Autowired(required = true)
    private LogementRepository logementrepository;

    @Autowired(required = true)
    private UserRepository userrepository;

    @Autowired(required = true)
    private AnnouncementRepository announcementrepository;

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

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/getNbrRented/{id}")
    public int getNbrRented(int id){
        User user = userrepository.findById(id).orElse(null);
        List<Announcement> ann = announcementrepository.findAnnouncementsByUser(user);
        int count = 0;
        for (Announcement element : ann
        ) {
            if(element.getAnnouncementStatus() == false) {
                count ++;
            }

        }
        return count;
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/getNbrNotRented/{id}")
    public int getNbrNotRented(int id){
        User user = userrepository.findById(id).orElse(null);
        List<Announcement> ann = announcementrepository.findAnnouncementsByUser(user);
        int count = 0;
        for (Announcement element : ann
        ) {
            if(element.getAnnouncementStatus() == true) {
                count ++;
            }

        }
        return count;
    }
}
