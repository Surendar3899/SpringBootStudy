package com.conquervictory.courseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conquervictory.courseregistrationsystem.model.CourseRegistry;

@Repository
public interface CourseRegistryRepo extends JpaRepository<CourseRegistry,Integer> {

}
