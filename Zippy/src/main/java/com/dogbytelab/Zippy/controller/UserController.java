package com.dogbytelab.Zippy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogbytelab.Zippy.dto.UserDto;
import com.dogbytelab.Zippy.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String>register(@Valid @RequestBody UserDto userDto){
		Integer userId = userService.register(userDto);
		String message = "User Register with user id : "+userId;
		return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
}
