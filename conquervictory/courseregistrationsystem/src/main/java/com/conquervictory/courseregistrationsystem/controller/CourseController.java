package com.conquervictory.courseregistrationsystem.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conquervictory.courseregistrationsystem.model.Course;
import com.conquervictory.courseregistrationsystem.model.CourseRegistry;
import com.conquervictory.courseregistrationsystem.service.CourseService;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
//@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://127.0.0.1:4200"})
//@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CourseController {


    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<Course> availableCourses(){
        log.info("availablecourses called");
        System.out.println(courseService.availableCourses());
        return courseService.availableCourses();
    }

    

    @PostMapping("courses/register")
    public String enrollCourse(@RequestParam("name") String name,
                               @RequestParam("emailId") String emailId,
                               @RequestParam("courseName") String courseName){
        System.out.println("enrollCourse");                        
        courseService.enrollCourse(name,emailId,courseName);
        return "Congratulations! "+name+" Enrollment Successful for "+courseName;
    }

    @GetMapping("/")
    public String home(){
        return "Welcome Home page";
    }


    @GetMapping("userinfo")
    public Map<String, Object> getUserInfo(Authentication authentication) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("username", authentication.getName());
        userInfo.put("roles", authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList()));
        return userInfo;
    }

}
