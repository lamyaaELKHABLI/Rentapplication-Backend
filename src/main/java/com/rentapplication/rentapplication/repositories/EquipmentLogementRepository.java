package com.rentapplication.rentapplication.repositories;

import com.rentapplication.rentapplication.entities.Equipment;
import com.rentapplication.rentapplication.entities.EquipmentLogement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentLogementRepository extends JpaRepository<EquipmentLogement, Integer> {

    List<EquipmentLogement> findByLogementId(Integer logement_id);
    void deleteAllByLogementId(Integer logement_id);
}