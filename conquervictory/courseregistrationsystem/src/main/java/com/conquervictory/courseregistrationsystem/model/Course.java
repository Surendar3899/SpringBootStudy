package com.conquervictory.courseregistrationsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Course {
    @Id
    private String courseId;
    private String curseName;
    private String trainer;
    private int durationInWeeks;



}
