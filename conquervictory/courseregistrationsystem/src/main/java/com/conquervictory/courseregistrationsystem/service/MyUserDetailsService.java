package com.conquervictory.courseregistrationsystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.conquervictory.courseregistrationsystem.model.UserPrincipal;
import com.conquervictory.courseregistrationsystem.model.Users;
import com.conquervictory.courseregistrationsystem.repository.UserRepository;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;



@Service
@Log4j2
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername called "+username);
        Users user = userRepository.getByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }else{
            System.out.println("user not null");
        }
        return new UserPrincipal(user);
    }

}
