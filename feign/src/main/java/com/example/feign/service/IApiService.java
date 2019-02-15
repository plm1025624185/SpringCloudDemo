package com.example.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 调用服务提供者
 * @author pankarl
 *
 */
@FeignClient(value="worker")
public interface IApiService {
	@GetMapping("/hello")
	public String hello();
}
