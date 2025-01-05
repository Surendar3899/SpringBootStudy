package com.jvlcode.practice.controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.jvlcode.practice.model.Product;
import com.jvlcode.practice.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping()
    public List<Product> getAllProducts(){
        System.out.println("getAllProducts called");
        //return Arrays.asList(Map.of("name","product1"));
        //return Arrays.asList(Collections.singletonMap("name", "product1"));
        return productService.getAllProducts();
    }

    @GetMapping("/category")
    public List<Map<String,Object>> getAllProducts1(){
        System.out.println("getAllProducts called");
        //return Arrays.asList(Map.of("name","product1","price",234));
        //return Arrays.asList(Collections.singletonMap("name", "product1","price",234));
        Map<String, Object> product = new HashMap<>();
        product.put("name", "product");
        product.put("price", "234");

        Map<String, Object> product1 = new HashMap<>();
        product1.put("name", "product1");
        product1.put("price", 536);
        return Arrays.asList(product,product1);
    }
    
}
