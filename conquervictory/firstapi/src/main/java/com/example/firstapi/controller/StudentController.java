package com.example.firstapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstapi.domain.Student;
import com.example.firstapi.service.StudentService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("students")
    public List<Student> getStudents(){
        return studentService.getAllStudents();

    }

    @PostMapping("students")
    public ResponseEntity<String> insertStudent(@RequestBody Student std){
        System.out.println("object");
        System.out.println(std.getName());
        return studentService.addStudent(std);
    }

    // This is for ui request
    @PostMapping("/add/student")
    public ResponseEntity<String> addStudent(@RequestParam("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("gender") String gender,
                           @RequestParam("technology") String technology){
        return studentService.addStudent(id,name,gender,technology);
    }

    @DeleteMapping("students/{id}")
    public String deleteStudent(@PathVariable("id") int id){
          return studentService.deleteStudent(id);
    }

    @GetMapping("students/{name}")
    public List<Student> findByStudent(@PathVariable("name") String stdname){
        System.out.println("findByStudent called");
        System.out.println(stdname);
        return studentService.findStudentByName(stdname);

    }


    @PostMapping("students/filter")
    public List<Student> getStudentsByGenderAndTechnology(@Param("gender") String gender,@Param("technology") String technology){
        System.out.println("getStudentsByGenderAndTechnology called ");
        System.out.println(gender +" "+technology);
        return studentService.getStudentsByGenderAndTechnology(gender,technology);
    }


    
}
