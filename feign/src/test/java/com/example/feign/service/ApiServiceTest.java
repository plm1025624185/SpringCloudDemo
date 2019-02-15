package com.example.feign.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceTest {

	@Autowired
	private IApiService apiService;
	
	@Test
	public void testHello() {
		System.out.println(apiService.hello());
	}
}