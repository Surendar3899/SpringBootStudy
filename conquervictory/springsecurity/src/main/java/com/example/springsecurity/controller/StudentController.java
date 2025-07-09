package com.example.springsecurity.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.model.Student;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(Arrays.asList(new Student(1,"surendar","java"),new Student(2, "Ranjith", "AI")));

    @GetMapping("/students")
    public List<Student> getStudents(){
       return this.students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getsCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }


    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        students.add(student);
    }

}
