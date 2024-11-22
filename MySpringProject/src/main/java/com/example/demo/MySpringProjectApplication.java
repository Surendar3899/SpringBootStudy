package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MySpringProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MySpringProjectApplication.class, args);
		Home h = context.getBean(Home.class);
		h.connect();
		
		// Home h1=context.getBean(Home.class);
		// h1.connect();
		
	}

}
