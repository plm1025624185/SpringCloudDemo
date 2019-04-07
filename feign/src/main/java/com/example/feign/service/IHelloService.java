package com.example.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.feign.service.impl.HelloServiceError;

@FeignClient(value = "worker", fallback = HelloServiceError.class)
public interface IHelloService {
	@GetMapping("/hello")
	String hello();
}
