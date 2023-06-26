package com.example.demo.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserUpdateMapper;
import com.example.demo.model.UserUpdateModel;
import com.example.demo.service.UserUpdateService;
@Service
public class UserUpdateServiceImpl implements UserUpdateService {
	
	@Resource UserUpdateMapper userUpdateMapper;

	@Override
	public Object userUpdate(UserUpdateModel userUpdateModel) {
		
		return userUpdateMapper.userUpdate(userUpdateModel);
	}

}
