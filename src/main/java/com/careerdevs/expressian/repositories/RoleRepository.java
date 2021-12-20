package com.example.springjwtauth.repositories;

import com.example.springjwtauth.entities.ERole;
import com.example.springjwtauth.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
