package com.jvlcode.practice.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
   
    private String description;
    private double ratings;
    private String category;
    private String seller;
    private int stock;
    private int numOfReviews;

    @ElementCollection
    @Column(name = "image_url")
    private List<String> images;

    public Product(String name, double price, String description, double ratings, String category, String seller,
    int stock, int numOfReviews, List<String> images) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.ratings = ratings;
        this.category = category;
        this.seller = seller;
        this.stock = stock;
        this.numOfReviews = numOfReviews;
        this.images = images;
    }

    public Product() {
    }

    

}
