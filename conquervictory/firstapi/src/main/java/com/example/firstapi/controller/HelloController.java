package com.example.firstapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String  greet(){
        return "Hello Conquer";
    }


    @GetMapping("/about")
    public String about(){
        return "Conquer victory is youtube channel";
    }

}
