package com.conquervictory.courseregistrationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conquervictory.courseregistrationsystem.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course,String> {

}
