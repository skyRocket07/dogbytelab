package com.dogbytelab.Zippy.service;

import com.dogbytelab.Zippy.dto.UserDto;

public interface UserService {

	Integer register(UserDto userDto);

	Boolean verify(Integer token);

}
