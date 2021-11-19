package com.rentapplication.rentapplication.repositories;

import com.rentapplication.rentapplication.entities.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentapplication.rentapplication.entities.Functionality;

@Repository
public interface FunctionalityRepository extends JpaRepository<Functionality, Long> {
    Functionality findByFunctionalityTitle(String name);
}