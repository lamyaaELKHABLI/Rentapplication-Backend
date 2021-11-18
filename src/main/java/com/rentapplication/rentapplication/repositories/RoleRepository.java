package com.rentapplication.rentapplication.repositories;

import com.rentapplication.rentapplication.entities.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentapplication.rentapplication.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleTitle(String name);
}
