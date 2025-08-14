package com.conquervictory.courseregistrationsystem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CourseRegistry {


    public CourseRegistry(String name2, String emailId2, String courseName2) {
        this.name = name2;
        this.emailId = emailId2;
        this.courseName = courseName2;
        this.dateCreated = new Date();
    }

    public CourseRegistry(){

    }


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String emailId;
    private String courseName;
    private Date dateCreated;

}
