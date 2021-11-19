package com.rentapplication.rentapplication.repositoryL;

import com.rentapplication.rentapplication.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
}