package com.example.springsecurity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("")
    public String home(HttpServletRequest request){    
        return "Homepage "+request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(){
        return "Conquer victory";
    }

}
