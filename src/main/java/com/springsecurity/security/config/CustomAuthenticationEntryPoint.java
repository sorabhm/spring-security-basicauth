package com.springsecurity.security.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	
	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("TEST_REALM");
		super.afterPropertiesSet();
	}


	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		System.out.println("Auth type=" + request.getAuthType());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.addHeader("WWW-Authenticate", "Basic Realm=" + getRealmName());
		
		PrintWriter pw = response.getWriter();
		pw.println("HTTP STATUS 401 : " + authException.getMessage());
	}

}
