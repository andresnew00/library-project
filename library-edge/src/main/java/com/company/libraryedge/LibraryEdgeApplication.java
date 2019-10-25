package com.company.libraryedge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class LibraryEdgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryEdgeApplication.class, args);
	}

}
