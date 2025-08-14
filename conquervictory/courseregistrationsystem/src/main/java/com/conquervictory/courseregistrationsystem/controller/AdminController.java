package com.conquervictory.courseregistrationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conquervictory.courseregistrationsystem.model.CourseRegistry;
import com.conquervictory.courseregistrationsystem.model.Users;
import com.conquervictory.courseregistrationsystem.service.CourseService;
import com.conquervictory.courseregistrationsystem.service.UserService;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @PostMapping("/add-user")
    public void addUser(@RequestBody Users user){
      userService.addUser(user);
    }

    @GetMapping("/courses-enrolled")
    public List<CourseRegistry> enrolledStudents(){
        return courseService.enrolledStudents();
    }
}
