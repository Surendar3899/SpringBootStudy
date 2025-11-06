package com.springangular.demouiback.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200") // allow Angular dev server
public class HelloCOntroller {

    @GetMapping("/api/message")
    public String getMessage() {
        return "Hello from Spring Boot2!";
    }

}
