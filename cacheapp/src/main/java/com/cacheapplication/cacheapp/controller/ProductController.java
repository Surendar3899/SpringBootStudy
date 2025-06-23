package com.cacheapplication.cacheapp.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cacheapplication.cacheapp.dto.ProductDto;
import com.cacheapplication.cacheapp.model.Product;
import com.cacheapplication.cacheapp.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/insert")
    public ResponseEntity<Product> insertProduct(@Valid @RequestBody ProductDto request) {
        log.info("Received request to insert product: {}", request.getId());
        Product product = service.insertProduct(request);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable String id) {
        log.info("getProduct called  "+id);
        //return service.getProduct(id);
        Product product = service.getProduct(id);
        return "Product name: "+product.getName()+"\n"+"Product Id:   "+product.getId();
    }
}
