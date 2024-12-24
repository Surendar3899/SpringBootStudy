package com.payilagam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("addUser")
	public String user() {
		System.out.println("addUser called");
		return "index";
		
	}
	
	@RequestMapping("index")
	public String user1() {
		System.out.println("index called");
		return "index";
		
	}
	

}
