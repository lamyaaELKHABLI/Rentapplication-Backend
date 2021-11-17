package com.rentapplication.rentapplication.repositoryL;

import com.rentapplication.rentapplication.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}