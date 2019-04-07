package com.example.feign.service.impl;

import org.springframework.stereotype.Service;

import com.example.feign.service.IHelloService;

@Service
public class HelloServiceError implements IHelloService {

	@Override
	public String hello() {
		return "服务器出错！";
	}

}
