package com.rentapplication.rentapplication.repositories;

import com.rentapplication.rentapplication.entities.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentapplication.rentapplication.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByCityTitle(String name);

}
