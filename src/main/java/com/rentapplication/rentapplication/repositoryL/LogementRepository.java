package com.rentapplication.rentapplication.repositoryL;

import com.rentapplication.rentapplication.entities.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogementRepository extends JpaRepository<Logement, Long> {
}