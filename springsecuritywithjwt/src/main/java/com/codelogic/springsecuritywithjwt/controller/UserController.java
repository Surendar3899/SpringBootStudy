package com.codelogic.springsecuritywithjwt.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelogic.springsecuritywithjwt.security.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${role.admin}")
    private String roleAdmin;

    @Value("${role.user}")
    private String roleUser;


    //Endpoint to access user protected resources

    @GetMapping("/protected-data")
    public ResponseEntity<String> getProtectedData(@RequestHeader("Authorization") String token) {
        System.out.println("getProtectedData called");
        //token = null;
        if(token != null && token.startsWith("Bearer ")){
            System.out.println("token not null");
            String jwtToken = token.substring(6);   // remove bearer prefix

            try{
                if(jwtUtil.isTokenValid(jwtToken)){
                    System.out.println("Token Valid");
                    String username = jwtUtil.extractUserName(jwtToken);  // EXTRACT USERNAME FROM THE JWT Token
                    
                    Set<String> roles = jwtUtil.extractRoles(jwtToken);
                    System.out.println("roles >>>"+roles);
                    System.out.println("roles >>>"+roles.getClass());

                    if (roles.size() == 1) {
                        String[] splitRoles = roles.iterator().next().split(",");
                        roles = new HashSet<>(Arrays.asList(splitRoles));
                    }

                    if(roles.contains(roleAdmin)){
                        return ResponseEntity.ok("Welcome "+username +" Here is the "+roles+" -specific data.");

                    }else if(roles.contains(roleUser)){
                        return ResponseEntity.ok("Welcome "+username +" Here is the "+roles+" -specific data.");
                    }else{
                        return ResponseEntity.status(403).body("Access Denied: you don't have the necessary role");
                    }

                    
                    
                }
            }catch(Exception ex){
                System.out.println("Exception caught: " + ex.getMessage());  // Debugging
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Token");

            }

        }
        System.out.println("not if");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authorization Header missing or invalid");
    }
    



}
