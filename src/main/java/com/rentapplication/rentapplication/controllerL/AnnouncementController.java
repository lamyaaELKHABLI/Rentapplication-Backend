package com.rentapplication.rentapplication.controllerL;

import com.rentapplication.rentapplication.entities.Announcement;
import com.rentapplication.rentapplication.entities.Logement;
import com.rentapplication.rentapplication.entities.User;
import com.rentapplication.rentapplication.repositoryL.AnnouncementRepository;
import com.rentapplication.rentapplication.repositoryL.LogementRepository;
import com.rentapplication.rentapplication.repositoryL.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/announcement")
    public Announcement createAnnouncement(@RequestBody Announcement announcement){
        User user = userrepository.findById(1).orElse(null);
        Logement newlogement = logementrepository.save(announcement.getLogement());
        announcement.setLogement(newlogement);
        announcement.setUser(user);
        return announcementrepository.save(announcement);
    }
}
