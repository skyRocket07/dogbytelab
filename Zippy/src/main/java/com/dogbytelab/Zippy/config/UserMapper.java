package com.dogbytelab.Zippy.config;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dogbytelab.Zippy.dto.UserDto;
import com.dogbytelab.Zippy.entity.User;

@Mapper 
public interface UserMapper {
 
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class ); 
 
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    UserDto toDto(User user); 
    
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User toEntity(UserDto userDto);
}