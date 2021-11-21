package com.rentapplication.rentapplication.repositories;

import com.rentapplication.rentapplication.entities.Picture;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
    List<Picture> findByLogementId(Integer logement_id);
    void deleteAllByLogementId(Integer logement_id);
}