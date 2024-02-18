package com.dogbytelab.Zippy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dogbytelab.Zippy.dto.UserDto;
import com.dogbytelab.Zippy.service.EmailService;
import com.dogbytelab.Zippy.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/register")
	public ResponseEntity<String>register(@Valid @RequestBody UserDto userDto){
		Integer userId = userService.register(userDto);
		String message = "User Register with user id : "+userId;
//		String emailContent = "Welcome to our platform! Your account has been successfully registered.";
		
		// Assuming your application runs on port 8080
		String verificationLink = "http://localhost:8080/api/verify?token=" + userId;

		// Set the message text with the verification link
		String emailContent = "Please click the link below to verify your email: " + verificationLink;

		
		
		emailService.sendEmail(userDto.getEmail(), "Account Registration Confirmation", emailContent);
		
		return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
	
	@GetMapping("/verify")
	public ResponseEntity<String>verify(@RequestParam Integer token){
		String  message;
		if(userService.verify(token)) {
			message = "Email verified successfully";
		}
		else {
			message = "Invalid link";
		}
		
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
}
