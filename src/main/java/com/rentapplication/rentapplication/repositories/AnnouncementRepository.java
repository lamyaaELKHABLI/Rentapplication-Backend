package com.rentapplication.rentapplication.repositories;

import com.rentapplication.rentapplication.entities.Announcement;
import com.rentapplication.rentapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
    List<Announcement> findAnnouncementsByUser(User user);
}