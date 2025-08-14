package com.example.springsecurity.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassWordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "admin1234";
        String encodePassword = passwordEncoder.encode(password);
        System.out.println(encodePassword+":");
    }

}
