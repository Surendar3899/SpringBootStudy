package com.cacheapplication.cacheapp.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cacheapplication.cacheapp.dto.ProductDto;
import com.cacheapplication.cacheapp.model.Product;
import com.cacheapplication.cacheapp.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(value = "products", key = "#id")
    public Product getProduct(String id) {
        System.out.println("Fetching from MySQL...");
        return productRepository.findById(id).orElse(null);
    }

    @CachePut(value = "products", key = "#request.id")
    public Product insertProduct(ProductDto request) {
        log.info("Inserting product with ID: {}", request.getId());
        Product product = new Product();
        product.setId(request.getId());
        product.setName(request.getName());
        Product savedProduct = productRepository.save(product);
        log.debug("Product inserted: ID={}, Name={}", savedProduct.getId(), savedProduct.getName());
        return savedProduct;
    }
}