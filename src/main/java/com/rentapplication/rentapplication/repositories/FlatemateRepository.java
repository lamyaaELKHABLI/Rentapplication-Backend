package com.rentapplication.rentapplication.repositories;

import com.rentapplication.rentapplication.entities.Flatmmate;
import com.rentapplication.rentapplication.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlatemateRepository extends JpaRepository<Flatmmate, Integer> {
    List<Flatmmate> findByLogementId(Integer logement_id);
}
