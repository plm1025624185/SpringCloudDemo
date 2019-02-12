package com.example.worker2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Worker2Application {

	public static void main(String[] args) {
		SpringApplication.run(Worker2Application.class, args);
	}

}

