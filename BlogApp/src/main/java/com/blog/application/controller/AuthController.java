package com.blog.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.application.dto.LoginRequest;
import com.blog.application.dto.RegisterRequest;
import com.blog.application.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<HttpStatus> signup(@RequestBody RegisterRequest registerRequest)
	{
		authService.signup(registerRequest);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest)
	{
		return authService.login(loginRequest);
	}

}
