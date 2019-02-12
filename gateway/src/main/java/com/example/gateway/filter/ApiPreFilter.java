package com.example.gateway.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 服务拦截，需要继承ZuulFilter
 */
@Component
public class ApiPreFilter extends ZuulFilter {
	private final static Logger logger = LoggerFactory.getLogger(ApiPreFilter.class);

	/**
	 * 表示是否过滤，这里可以做逻辑判断，true为过滤，false为不过滤
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 过滤器执行的具体逻辑，在这里可以做权限判断，合法性校验等等
	 */
	@Override
	public Object run() throws ZuulException {
		logger.info("路由之前进行拦截");
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		String token = request.getParameter("token");
		if(!"123".equals(token)) {
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(401);
			try {
				requestContext.getResponse().getWriter().write("token is invalid.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 过滤类型，可选值有pre(路由之前)，routing(路由之时)，post(路由之后)，error(发生错误时调用)
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	/**
	 * 过滤的顺序，如果有多个过滤器，则数字越小越先执行
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
