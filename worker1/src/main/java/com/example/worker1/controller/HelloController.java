package com.example.worker1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${spring.application.name}")
	private String appName;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/hello")
	public String hello() {
		return String.format("APP name is %s, Server port is %s", appName, port);
	}
}
