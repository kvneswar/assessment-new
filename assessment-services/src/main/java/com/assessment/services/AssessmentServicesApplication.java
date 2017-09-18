package com.assessment.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AssessmentServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessmentServicesApplication.class, args);
	}

	@Bean
	public ErrorAttributes errorAttributes() {
		return new DefaultErrorAttributes();
	}
}
