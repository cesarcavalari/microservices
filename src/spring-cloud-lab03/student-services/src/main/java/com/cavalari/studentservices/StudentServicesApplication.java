package com.cavalari.studentservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StudentServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServicesApplication.class, args);
	}
}
