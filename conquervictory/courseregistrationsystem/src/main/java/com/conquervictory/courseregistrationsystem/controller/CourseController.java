package com.conquervictory.courseregistrationsystem.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conquervictory.courseregistrationsystem.model.Course;
import com.conquervictory.courseregistrationsystem.model.CourseRegistry;
import com.conquervictory.courseregistrationsystem.service.CourseService;

@RestController
//@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://127.0.0.1:4200"})
@CrossOrigin(origins = "http://127.0.0.1:4200/register")
public class CourseController {


    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<Course> availableCourses(){
        return courseService.availableCourses();
    }


    @GetMapping("courses/enrolled")
    public List<CourseRegistry> enrolledStudents(){
        return courseService.enrolledStudents();
    }

    @PostMapping("courses/register")
    public String enrollCourse(@RequestParam("name") String name,
                               @RequestParam("emailId") String emailId,
                               @RequestParam("courseName") String courseName){
        System.out.println("enrollCourse");                        
        courseService.enrollCourse(name,emailId,courseName);
        return "Congratulations! "+name+" Enrollment Successful for "+courseName;
    }

}
