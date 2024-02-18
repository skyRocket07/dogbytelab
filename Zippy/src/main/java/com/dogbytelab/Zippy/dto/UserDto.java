package com.dogbytelab.Zippy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {
	
	@NotBlank(message = "Username is required")
	private String username;
	
	@NotBlank(message = "Email is required")
    @Pattern(regexp = "[A-Za-z0-9]+@[A-Za-z]+.[A-Za-z]+", message = "Invalid email format")
	private String email;
	
	@NotBlank(message = "Password is required")
    @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters long")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
