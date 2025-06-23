package com.example.firstapi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Student {
    @Id
    int id;
    String name;
    String gender;
    String technology;
   
    

}
