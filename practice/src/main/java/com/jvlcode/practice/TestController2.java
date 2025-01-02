package com.jvlcode.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
@CrossOrigin(origins = "*")
//@RequestMapping("/controllerB")	
public class TestController2 {	
	
	
	
	@GetMapping("/test")
	public String test() {
		System.out.println("test1 called");
		return "Helloqss World1 from test new test method";
	}

	
	@GetMapping("/testnew")
	public String test1() {
		System.out.println("testnew called");
		return "Helloqss World1 from test new";
	}

}
