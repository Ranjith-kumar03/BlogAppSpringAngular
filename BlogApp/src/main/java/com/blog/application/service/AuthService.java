package com.blog.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.blog.application.config.SecurityConfig;
import com.blog.application.dto.LoginRequest;
import com.blog.application.dto.RegisterRequest;
import com.blog.application.model.User;
import com.blog.application.repository.UserRepository;
import com.blog.application.security.JWTTokenProvider;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository _userRepository;
	
	@Autowired
	private PasswordEncoder _encoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTTokenProvider jwtTokenProvider;
	
	public void signup(RegisterRequest registerRequest)
	{
		User user=new User();
		user.setUsername(registerRequest.getUser_name());
	
	
		user.setPassword(_encoder.encode(registerRequest.getPassword()));
		user.setEmail(registerRequest.getEmail());
		_userRepository.save(user);
	}
	
	
	
	public String login(LoginRequest loginRequest)
	{
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		return jwtTokenProvider.generateToken(authenticate);
	}

}
