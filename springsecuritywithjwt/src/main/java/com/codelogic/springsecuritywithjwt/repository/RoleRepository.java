package com.codelogic.springsecuritywithjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codelogic.springsecuritywithjwt.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role,Long> {
    Optional<Role> findByName(String name);
}
