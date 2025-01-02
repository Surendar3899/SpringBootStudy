package com.jvlcode.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class JVLCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(JVLCartApplication.class, args);
	}

}
