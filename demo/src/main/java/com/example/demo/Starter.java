package com.example.demo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Starter {
	
	void run() {
		System.out.println("run called");
	}

}
