package com.conquervictory.courseregistrationsystem.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassWordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "admin123";
        String encodePassword = passwordEncoder.encode(password);
        System.out.println(encodePassword+":");
    }

}
