package com.vendingmachine.config;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.vendingmachine.model.DockerLoginResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -7858869558953243875L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		DockerLoginResponse dl = new DockerLoginResponse();
		dl.setIdentityToken("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1OTkwMDI5NjIsImlhdCI6MTU5ODk4NDk2Mn0.LIOwjBoZGIc7qM0DanXgjrjmZdFw6irS5rfqhPX6eIg1sVF-TC4YZVBnZcRXvm_6y3gfREhO3weg2KR7Kka6jg");
		dl.setStatus("Login Succeeded");
		 ResponseEntity.ok(dl);
		 response.setStatus(HttpServletResponse.SC_OK);
		//response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}
