package com.rentapplication.rentapplication.controllerL;

import com.rentapplication.rentapplication.entities.Announcement;
import com.rentapplication.rentapplication.entities.Logement;
import com.rentapplication.rentapplication.repositoryL.AnnouncementRepository;
import com.rentapplication.rentapplication.repositoryL.LogementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AnnouncementController {

    @Autowired(required = true)
    private AnnouncementRepository announcementrepository;

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/announcements")
    public List<Announcement> getAllLogement(){
        return announcementrepository.findAll();
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/announcement")
    public Announcement createAnnouncement(@RequestBody Announcement announcement){
        return announcementrepository.save(announcement);
    }
}
