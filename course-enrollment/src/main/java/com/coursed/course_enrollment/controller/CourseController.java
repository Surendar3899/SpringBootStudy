package com.coursed.course_enrollment.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coursed.course_enrollment.domain.Course;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
       private List<Course> courses = new ArrayList<>(Arrays.asList(
        new Course(1L, "Java Basics", "Introduction to Java Programming"),
        new Course(2L, "Spring Boot", "Building APIs with Spring Boot"),
        new Course(3L, "Angular Fundamentals", "Front-end development with Angular")
    ));

    private List<Course> enrolled = new ArrayList<>();

    @GetMapping
    public List<Course> getAllCourses() {
        return courses;
    }

    @PostMapping("/enroll/{id}")
    public String enroll(@PathVariable Long id) {
        courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .ifPresent(enrolled::add);
        return "Enrolled Successfully!";
    }

    @GetMapping("/enrolled")
    public List<Course> getEnrolledCourses() {
        return enrolled;
    }
}
