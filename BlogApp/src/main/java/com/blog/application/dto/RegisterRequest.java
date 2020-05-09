package com.blog.application.dto;

import lombok.Data;

@Data
public class RegisterRequest {
	private String user_name;
	private String password;
    private String email;
}
