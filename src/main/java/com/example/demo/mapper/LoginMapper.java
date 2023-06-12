package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LoginModel;

@Repository
@Mapper
public interface LoginMapper {
	
	LoginModel login(LoginModel loginModel);

}
