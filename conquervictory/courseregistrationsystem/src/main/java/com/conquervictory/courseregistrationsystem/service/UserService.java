package com.conquervictory.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.conquervictory.courseregistrationsystem.model.Users;
import com.conquervictory.courseregistrationsystem.repository.UserRepository;

import lombok.extern.log4j.Log4j2;



@Service
@Log4j2
public class UserService {

    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public void addUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepository.save(user);
    }

    @Cacheable("usersCache")
    public List<Users> getUsers(){
        log.info("get userservice called");
        return userRepository.findAll();
    }

    @Cacheable("singleusercache")
    public Users getByUserid(int id) {
        System.out.println(">>> Fetching user " + id + " from DB...");
        return userRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
