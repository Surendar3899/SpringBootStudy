package com.codelogic.springsecuritywithjwt.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TestController {
    

    @GetMapping("/test")
    public String test() {
        System.out.println("test callled");
        return "Hello World";
    }
    
}
