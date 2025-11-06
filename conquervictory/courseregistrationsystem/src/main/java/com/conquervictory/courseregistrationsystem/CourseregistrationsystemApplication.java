package com.conquervictory.courseregistrationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CourseregistrationsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseregistrationsystemApplication.class, args);
	}

}
