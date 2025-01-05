package com.codelogic.springsecuritywithjwt.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codelogic.springsecuritywithjwt.entity.User;
import com.codelogic.springsecuritywithjwt.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService{

     
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername called");
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found:  "+username));
        
         
        //Map the roles to authorities

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
    }

}
