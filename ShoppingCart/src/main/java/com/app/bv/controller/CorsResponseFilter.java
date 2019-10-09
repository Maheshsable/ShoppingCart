package com.app.bv.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CorsResponseFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        	HttpServletResponse httpResponse = (HttpServletResponse) response;
	        httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8585");
	        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        	httpResponse.setHeader("Access-Control-Allow-Headers", "X-Auth-Token, Content-Type");
	        httpResponse.setHeader("Access-Control-Expose-Headers", "custom-header1, custom-header2");
        	httpResponse.setHeader("Access-Control-Allow-Credentials", "false");
	        httpResponse.setHeader("Access-Control-Max-Age", "4800");
	        System.out.println("---CORS Configuration Completed---");
	        chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
