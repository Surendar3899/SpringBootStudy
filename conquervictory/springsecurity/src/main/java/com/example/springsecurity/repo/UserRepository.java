package com.example.springsecurity.repo;

import org.springframework.stereotype.Repository;

import com.example.springsecurity.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{
    Users getByUsername(String username);
}
