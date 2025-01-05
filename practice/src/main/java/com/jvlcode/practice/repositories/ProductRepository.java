package com.jvlcode.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jvlcode.practice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
