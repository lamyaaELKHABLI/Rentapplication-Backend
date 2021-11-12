package com.rentapplication.rentapplication.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user_announcement", schema = "rentapplication", catalog = "")
public class UserAnnouncement {
    private int userAnnouncementId;
    private Date userAnnouncementDate;
    private byte userAnnouncementStatus;
    private int userId;
    private int announcementId;

    @Id
    @Column(name = "user_announcement_id")
    public int getUserAnnouncementId() {
        return userAnnouncementId;
    }

    public void setUserAnnouncementId(int userAnnouncementId) {
        this.userAnnouncementId = userAnnouncementId;
    }

    @Basic
    @Column(name = "user_announcement_date")
    public Date getUserAnnouncementDate() {
        return userAnnouncementDate;
    }

    public void setUserAnnouncementDate(Date userAnnouncementDate) {
        this.userAnnouncementDate = userAnnouncementDate;
    }

    @Basic
    @Column(name = "user_announcement_status")
    public byte getUserAnnouncementStatus() {
        return userAnnouncementStatus;
    }

    public void setUserAnnouncementStatus(byte userAnnouncementStatus) {
        this.userAnnouncementStatus = userAnnouncementStatus;
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
    @Column(name = "announcement_id")
    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAnnouncement that = (UserAnnouncement) o;

        if (userAnnouncementId != that.userAnnouncementId) return false;
        if (userAnnouncementStatus != that.userAnnouncementStatus) return false;
        if (userId != that.userId) return false;
        if (announcementId != that.announcementId) return false;
        if (userAnnouncementDate != null ? !userAnnouncementDate.equals(that.userAnnouncementDate) : that.userAnnouncementDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userAnnouncementId;
        result = 31 * result + (userAnnouncementDate != null ? userAnnouncementDate.hashCode() : 0);
        result = 31 * result + (int) userAnnouncementStatus;
        result = 31 * result + userId;
        result = 31 * result + announcementId;
        return result;
    }
}
