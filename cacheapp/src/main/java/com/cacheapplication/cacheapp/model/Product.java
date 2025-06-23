package com.cacheapplication.cacheapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product implements Serializable {

    @Id
    private String id;

    private String name;

    // Constructors, Getters, Setters
    public Product() {}

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
}
