package com.check.ofac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.check.ofac.controller.NameMatcher;

@SpringBootApplication
public class OfacscoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OfacscoreApplication.class, args);
		NameMatcher nm = context.getBean(NameMatcher.class);
		nm.runCheck();
		
	}

}
