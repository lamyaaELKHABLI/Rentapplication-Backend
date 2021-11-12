package com.rentapplication.rentapplication.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Announcement {
    private int announcementId;
    private String announcementTitle;
    private String announcementDescription;
    private Timestamp announcementCreatedAt;
    private byte announcementDeleted;
    private byte announcementStatus;
    private int userId;
    private int logementId;

    @Id
    @Column(name = "announcement_id")
    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    @Basic
    @Column(name = "announcement_title")
    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    @Basic
    @Column(name = "announcement_description")
    public String getAnnouncementDescription() {
        return announcementDescription;
    }

    public void setAnnouncementDescription(String announcementDescription) {
        this.announcementDescription = announcementDescription;
    }

    @Basic
    @Column(name = "announcement_created_at")
    public Timestamp getAnnouncementCreatedAt() {
        return announcementCreatedAt;
    }

    public void setAnnouncementCreatedAt(Timestamp announcementCreatedAt) {
        this.announcementCreatedAt = announcementCreatedAt;
    }

    @Basic
    @Column(name = "announcement_deleted")
    public byte getAnnouncementDeleted() {
        return announcementDeleted;
    }

    public void setAnnouncementDeleted(byte announcementDeleted) {
        this.announcementDeleted = announcementDeleted;
    }

    @Basic
    @Column(name = "announcement_status")
    public byte getAnnouncementStatus() {
        return announcementStatus;
    }

    public void setAnnouncementStatus(byte announcementStatus) {
        this.announcementStatus = announcementStatus;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "logement_id")
    public int getLogementId() {
        return logementId;
    }

    public void setLogementId(int logementId) {
        this.logementId = logementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Announcement that = (Announcement) o;

        if (announcementId != that.announcementId) return false;
        if (announcementDeleted != that.announcementDeleted) return false;
        if (announcementStatus != that.announcementStatus) return false;
        if (userId != that.userId) return false;
        if (logementId != that.logementId) return false;
        if (announcementTitle != null ? !announcementTitle.equals(that.announcementTitle) : that.announcementTitle != null)
            return false;
        if (announcementDescription != null ? !announcementDescription.equals(that.announcementDescription) : that.announcementDescription != null)
            return false;
        if (announcementCreatedAt != null ? !announcementCreatedAt.equals(that.announcementCreatedAt) : that.announcementCreatedAt != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = announcementId;
        result = 31 * result + (announcementTitle != null ? announcementTitle.hashCode() : 0);
        result = 31 * result + (announcementDescription != null ? announcementDescription.hashCode() : 0);
        result = 31 * result + (announcementCreatedAt != null ? announcementCreatedAt.hashCode() : 0);
        result = 31 * result + (int) announcementDeleted;
        result = 31 * result + (int) announcementStatus;
        result = 31 * result + userId;
        result = 31 * result + logementId;
        return result;
    }
}
