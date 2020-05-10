package com.blog.application.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.application.model.User;
import com.blog.application.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository _userRepo;
	

	@Override
	public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
		User user=_userRepo.findByUsername(user_name);//.orElseThrow(() -> new UsernameNotFoundException("No User Found "+ username));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,
				true, true, true, getAuthorities("ROLE_USER"));
			
			
	}


	private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
		
		return Collections.singletonList(new SimpleGrantedAuthority(role_user));
	}

}
