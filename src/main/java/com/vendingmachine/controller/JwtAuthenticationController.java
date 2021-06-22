package com.vendingmachine.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vendingmachine.config.JwtTokenUtil;
import com.vendingmachine.model.DockerLoginResponse;
import com.vendingmachine.model.JwtRequest;
import com.vendingmachine.model.JwtResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		DockerLoginResponse dl = new DockerLoginResponse();
		dl.setIdentityToken(token);
		dl.setStatus("Login Succeeded");
		return ResponseEntity.ok(dl);
	}
	
	@RequestMapping(value = "/v2", method = RequestMethod.GET)
	public ResponseEntity<?> v2(HttpServletRequest request)throws Exception {
		
		final String requestTokenHeader = request.getHeader("Authorization");

		System.out.println("X-Registry-Auth " +  request.getHeader("X-Registry-Auth"));
		System.out.println("XRA " + request.getHeader("XRA"));
		System.out.println("Method " + request.getMethod());
		System.out.println("AuthType " + request.getAuthType());
		System.out.println("PathInfo " + request.getPathInfo());
		System.out.println("identitytoken " + request.getHeader("identitytoken"));

		return ResponseEntity.ok("Success");
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
