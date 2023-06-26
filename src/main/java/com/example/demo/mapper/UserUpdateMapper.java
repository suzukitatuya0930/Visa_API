package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.UserUpdateModel;

@Mapper
public interface UserUpdateMapper {
	
	int userUpdate(UserUpdateModel userUpdateModel);

}
