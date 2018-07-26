package com.studentcourse.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.studentcourse")
public class StudentCourseApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(StudentCourseApplication.class, args);

	}

}
