package com.rentapplication.rentapplication.entities;

import com.rentapplication.rentapplication.entities.Logement;
import com.rentapplication.rentapplication.entities.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "announcement", indexes = {
        @Index(name = "user_id", columnList = "user_id"),
        @Index(name = "logement_id", columnList = "logement_id")
})
@Entity
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_id", nullable = false)
    private Integer id;

    @Column(name = "announcement_title", nullable = false)
    private String announcementTitle;

    @Column(name = "announcement_description", nullable = false)
    private String announcementDescription;

    @CreationTimestamp
    @Column(name = "announcement_created_at")
    private Instant announcementCreatedAt ;

    @Column(name = "announcement_deleted")
    private Boolean announcementDeleted = false;

    @Column(name = "announcement_status")
    private Boolean announcementStatus = true;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "logement_id", nullable = false)
    private Logement logement;

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getAnnouncementStatus() {
        return announcementStatus;
    }

    public void setAnnouncementStatus(Boolean announcementStatus) {
        this.announcementStatus = announcementStatus;
    }

    public Boolean getAnnouncementDeleted() {
        return announcementDeleted;
    }

    public void setAnnouncementDeleted(Boolean announcementDeleted) {
        this.announcementDeleted = announcementDeleted;
    }

    public Instant getAnnouncementCreatedAt() {
        return announcementCreatedAt;
    }

    public void setAnnouncementCreatedAt(Instant announcementCreatedAt) {
        this.announcementCreatedAt = announcementCreatedAt;
    }

    public String getAnnouncementDescription() {
        return announcementDescription;
    }

    public void setAnnouncementDescription(String announcementDescription) {
        this.announcementDescription = announcementDescription;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}