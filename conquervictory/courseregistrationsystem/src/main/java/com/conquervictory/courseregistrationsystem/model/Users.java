package com.conquervictory.courseregistrationsystem.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Users {

    @Id
    private int id;
    private String username;
    private String password;
    private String roles;
    private Date onboardDate = new Date();


}