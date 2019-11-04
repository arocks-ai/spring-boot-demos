package com.example.bikedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// NOTE: @SpringBootApplication indicates that it is spring boot application
// MVC APP: model and controller are separate packages

@SpringBootApplication
public class BikedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikedemoApplication.class, args);
	}

}
