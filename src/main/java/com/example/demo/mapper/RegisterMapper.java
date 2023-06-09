package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RegisterModel;

@Repository
@Mapper
public interface RegisterMapper {
	
	int register(RegisterModel registerModel);
	
	boolean checkEmailExists(String email);

}

