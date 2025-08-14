package com.conquervictory.courseregistrationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.conquervictory.courseregistrationsystem.model.Users;
import com.conquervictory.courseregistrationsystem.repository.UserRepository;



@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public void addUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepository.save(user);
    }

}
