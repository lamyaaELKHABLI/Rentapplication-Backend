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
    @GetMapping("/announcementsClient/{id}")
    public List<Announcement> getAllLogementClient(int id){
        User user = userrepository.findById(id).orElse(null);
        return announcementrepository.findAnnouncementsByUser(user);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/modifyAnnouncement/{id}")
    public Announcement modifyAnnouncement(@RequestBody Announcement announcement, @PathVariable("id") Integer id){
        Announcement newannouncement = announcementrepository.findById(id).orElse(null);
        newannouncement.setAnnouncementTitle(announcement.getAnnouncementTitle());
        newannouncement.setAnnouncementDescription(announcement.getAnnouncementDescription());
        announcementrepository.save(newannouncement);
        return newannouncement;
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/deleteAnnouncement/{id}")
    public String deleteAnnouncement(int id){
        announcementrepository.deleteById(id);
        return "Announcement deleted !";
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/detailsAnnouncement/{id}")
    public Announcement detailsAnnouncement(int id){
        return announcementrepository.findById(id).orElse(null);
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/getNbrAnn/{id}")
    public int getNbrAnn(int id){
        User user = userrepository.findById(id).orElse(null);
        List<Announcement> ann = announcementrepository.findAnnouncementsByUser(user);
        return ann.size();
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

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/modifyStatus/{id}")
    public Announcement modifyStatus(int id){
        Announcement anon = announcementrepository.findById(id).orElse(null);
        if(anon.getAnnouncementStatus() == true) {
            anon.setAnnouncementStatus(false);
        }
        else {
            anon.setAnnouncementStatus(true);
        }
        return announcementrepository.save(anon);
    }
}

