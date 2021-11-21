package com.rentapplication.rentapplication.repositoryL;

import com.rentapplication.rentapplication.entities.Equipment;
import com.rentapplication.rentapplication.entities.EquipmentLogement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer > {

}