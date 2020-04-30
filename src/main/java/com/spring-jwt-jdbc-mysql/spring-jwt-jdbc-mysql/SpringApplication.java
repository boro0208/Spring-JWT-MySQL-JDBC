package com.test.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.test.test","com.test"})
public class SpringApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(com.test.test.SpringApplication.class, args);

	}
}
