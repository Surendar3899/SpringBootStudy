package com.codelogic.springsecuritywithjwt.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelogic.springsecuritywithjwt.dto.RegisterRequest;
import com.codelogic.springsecuritywithjwt.entity.Role;
import com.codelogic.springsecuritywithjwt.entity.User;
import com.codelogic.springsecuritywithjwt.repository.RoleRepository;
import com.codelogic.springsecuritywithjwt.repository.UserRepository;
import com.codelogic.springsecuritywithjwt.security.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/auth")
public class AuthController {
     
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository userRepository,
            RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    

  
    @PostMapping("/register") 
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest){
        // check is username already exists
        System.out.println("register API Called");
        if(userRepository.findByUsername(registerRequest.getUsername()).isPresent()){
            return ResponseEntity.badRequest().body("Usernme is already taken");

        } 

        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());

        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        newUser.setPassword(encodedPassword);
        System.out.println("Encoded Password: "+encodedPassword);

        // convert role names to role entities and assign to user

        Set<Role> roles = new HashSet<>();
        for(String roleName:registerRequest.getRoles()){
            Role role = roleRepository.findByName(roleName).orElseThrow(() -> new RuntimeException("Role not found: "+roleName));
            roles.add(role);
        }

        newUser.setRoles(roles);
        userRepository.save(newUser);
        return ResponseEntity.ok("User Registered Successfully");    

    }


    // Login API - // lOGIN endpoint http://localhost:8080/auth/login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
        System.out.println("Login API Called");
         
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

        }catch(Exception e){
            System.out.println("Exception: "+e);
        }

        String token = jwtUtil.generateToken(loginRequest.getUsername());
        return ResponseEntity.ok(token);
    }
    
}
