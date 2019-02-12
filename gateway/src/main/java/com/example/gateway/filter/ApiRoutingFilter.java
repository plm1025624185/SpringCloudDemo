package com.example.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ApiRoutingFilter extends ZuulFilter {
	private final static Logger logger = LoggerFactory.getLogger(ApiRoutingFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		logger.info("路由之时进行拦截");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "routing";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
