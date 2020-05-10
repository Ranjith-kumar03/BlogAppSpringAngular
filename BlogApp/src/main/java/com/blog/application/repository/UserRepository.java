package com.blog.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.application.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String user_name);

}
