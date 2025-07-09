package com.conquervictory.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conquervictory.courseregistrationsystem.model.Course;
import com.conquervictory.courseregistrationsystem.model.CourseRegistry;
import com.conquervictory.courseregistrationsystem.repository.CourseRegistryRepo;
import com.conquervictory.courseregistrationsystem.repository.CourseRepo;

@Service
public class CourseService {
 
    @Autowired
    CourseRepo courseRepo;

    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<Course> availableCourses() {
        return courseRepo.findAll();
        
    }

    public List<CourseRegistry> enrolledStudents() {
        return courseRegistryRepo.findAll();
    }

    public void enrollCourse(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry = new CourseRegistry(name,emailId,courseName);
        courseRegistryRepo.save(courseRegistry);
    }

}
