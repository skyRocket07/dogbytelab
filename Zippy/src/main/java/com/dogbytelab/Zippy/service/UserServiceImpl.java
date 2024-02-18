package com.dogbytelab.Zippy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.dogbytelab.Zippy.dto.UserDto;
import com.dogbytelab.Zippy.entity.User;
import com.dogbytelab.Zippy.exception.DogByteLabException;
import com.dogbytelab.Zippy.repository.UserRepository;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private Environment environment;
	
	 @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;


	@Override
	public Integer register(UserDto userDto) {
		if(userRepository.existsByUsernameOrEmail(userDto.getUsername(),userDto.getEmail())) {
			throw new DogByteLabException(environment.getProperty("user.exists.error.message"));
		}
		User user = new User();
		// Hash the password before saving
        String hashedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
        
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setPassword(hashedPassword);
//		user.setPassword(userDto.getPassword());
		userRepository.save(user);
		return user.getUserId();
	}

}
