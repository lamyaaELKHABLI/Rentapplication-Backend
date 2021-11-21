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
import java.util.Optional;

@RestController
@RequestMapping
public class AnnouncementController {

    @Autowired(required = true)
    private AnnouncementRepository announcementrepository;

    @Autowired(required = true)
    private LogementRepository logementrepository;

    @Autowired(required = true)
    private UserRepository userrepository;

    @CrossOrigin("http://localhost:4200")
   @GetMapping("/announcements")

    public List<Announcement> getAllLogement(){
       return announcementrepository.findAll();
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/announcements/{id}")
    public Announcement getAllLogementbyID(@PathVariable Integer id){
        return announcementrepository.findById(id).orElse(null);
    }




    @CrossOrigin("http://localhost:4200")
    @PostMapping("/announcement")
    public Integer createAnnouncement(@RequestBody Announcement announcement){

        User user = userrepository.findByUsername(announcement.getUser().getUsername()).orElse(null);
        Logement newlogement = logementrepository.save(announcement.getLogement());
        announcement.setLogement(newlogement);
        announcement.setUser(user);
        Announcement newannouncement = announcementrepository.save(announcement);
        return newlogement.getId();
    }
}

