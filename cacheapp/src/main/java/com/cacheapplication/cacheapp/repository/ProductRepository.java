package com.cacheapplication.cacheapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cacheapplication.cacheapp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
