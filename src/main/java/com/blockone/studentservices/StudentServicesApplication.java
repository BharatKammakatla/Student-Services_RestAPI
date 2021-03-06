package com.blockone.studentservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class StudentServicesApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudentServicesApplication.class);
	}

	static Logger logger = LoggerFactory.getLogger(StudentServicesApplication.class);
	public static void main(String[] args) {
		logger.info("Application is starting");
		SpringApplication.run(StudentServicesApplication.class, args);
	}

}
