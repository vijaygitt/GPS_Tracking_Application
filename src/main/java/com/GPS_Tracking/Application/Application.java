package com.GPS_Tracking.Application;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The `Application` class is the main entry point for the GPS Tracking Spring Boot application.
 * This class configures the application and defines a `ModelMapper` bean.
 */
@SpringBootApplication
public class Application {
	/**
	 * The main method to start the GPS Tracking application.
	 *
	 * @param args The command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	/**
	 * Creates and configures a Spring bean of type `ModelMapper`.
	 *
	 * @return A new instance of the `ModelMapper` bean.
	 */
	@Bean
	public ModelMapper modelMapper(){

		return new ModelMapper();
	}
}
