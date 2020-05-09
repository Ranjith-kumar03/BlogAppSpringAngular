package com.blog.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.blog.application.config.SecurityConfig;
import com.blog.application.dto.RegisterRequest;
import com.blog.application.model.User;
import com.blog.application.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository _userRepository;
	
	@Autowired
	private PasswordEncoder _encoder;
	
	
	public void signup(RegisterRequest registerRequest)
	{
		User user=new User();
		user.setUser_name(registerRequest.getUser_name());
	
	
		user.setPassword(_encoder.encode(registerRequest.getPassword()));
		user.setEmail(registerRequest.getEmail());
		_userRepository.save(user);
	}

}
