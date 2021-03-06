package com.rentapplication.rentapplication.repositories;

import com.rentapplication.rentapplication.entities.LogementCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogementCategoryRepository extends JpaRepository<LogementCategory, Long> {
}