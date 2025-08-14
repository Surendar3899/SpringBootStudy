package com.conquervictory.courseregistrationsystem.repository;


import org.springframework.stereotype.Repository;

import com.conquervictory.courseregistrationsystem.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{
    Users getByUsername(String username);
}

