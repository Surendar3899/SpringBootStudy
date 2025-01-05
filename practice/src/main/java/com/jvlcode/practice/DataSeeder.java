package com.jvlcode.practice;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jvlcode.practice.model.Product;
import com.jvlcode.practice.repositories.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String ...args) throws Exception{
        // check if the table is Empty
        if (productRepository.count() == 0) {
            List<Product> productList = Arrays.asList(
                new Product("Laptop", 999.99, "High-performance laptop", 4.5, "Electronics", "TechSeller", 50, 150,Arrays.asList("https://picsum.photos/200/300")),
                new Product("Smartphone", 799.99, "Latest smartphone with 5G", 4.8, "Electronics", "PhoneSeller", 100, 200,Arrays.asList("https://picsum.photos/200/300")),
                new Product("Desk Chair", 129.99, "Ergonomic desk chair", 4.3, "Furniture", "ChairCo", 25, 75,Arrays.asList("https://picsum.photos/200/300")),
                new Product("Electric Kettle", 49.99, "Fast boiling electric kettle", 4.7, "Appliances", "HomeGoods", 200, 120,Arrays.asList("https://picsum.photos/200/300")),
                new Product("Monitor", 199.99, "27-inch 4K monitor", 4.6, "Electronics", "TechSeller", 30, 100,Arrays.asList("https://picsum.photos/200/300")),
                new Product("Bluetooth Speaker", 59.99, "Portable Bluetooth speaker", 4.4, "Electronics", "AudioShop", 150, 180,Arrays.asList("https://picsum.photos/200/300")),
                new Product("Air Fryer", 99.99, "Compact air fryer for healthy cooking", 4.5, "Kitchen", "HomeGoods", 75, 90,Arrays.asList("https://picsum.photos/200/300")),
                new Product("Gaming Console", 499.99, "Next-gen gaming console", 4.9, "Electronics", "GameStore", 20, 300,Arrays.asList("https://picsum.photos/200/300")),
                new Product("Running Shoes", 89.99, "Comfortable running shoes", 4.2, "Footwear", "ShoeBrand", 120, 50,Arrays.asList("https://picsum.photos/200/300"))
            );
            
            productRepository.saveAll(productList);
            System.out.println("Data Seeded Completed");
        }

    }
}
