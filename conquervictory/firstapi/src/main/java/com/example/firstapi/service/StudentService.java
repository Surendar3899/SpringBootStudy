package com.example.firstapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.firstapi.domain.Student;
import com.example.firstapi.repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public ResponseEntity<String> addStudent(Student std) {
        System.out.println("service addstudent called");

        if(studentRepo.existsById(std.getId())){
            //return "Student ALready Exists";
            return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body("Student with ID " + std.getId() + " already exists");
        }
        Student saved = studentRepo.save(std);
        if(saved != null){
            //return "Student Added Successfully";
            return ResponseEntity.status(HttpStatus.ACCEPTED)
            .body("Student with ID " + std.getId() + " Student Added Successfully");
        }else{
            //return "Student Added Failed";
            return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body("Student with ID " + std.getId() + " Student Added Failed");
        }
    }

    public String deleteStudent(int id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return "Student deleted successfully.";
        } else {
            return "Student with ID " + id + " not found.";
        }
    }

    public List<Student> findStudentByName(String name) {
        return studentRepo.findByName(name);
    }

    public List<Student> getStudentsByGenderAndTechnology(String gender, String tech) {
       return studentRepo.findByGenderAndTechnology(gender,tech);
    }

    public ResponseEntity<String> addStudent(int id, String name, String gender, String technology) {
        Student std = new Student(id,name,gender,technology);
        return addStudent(std);
    }

 

}
