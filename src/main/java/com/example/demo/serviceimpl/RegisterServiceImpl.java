package com.example.demo.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.RegisterMapper;
import com.example.demo.model.RegisterModel;
import com.example.demo.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Resource
	RegisterMapper registerMapper;
	
	@Override
	 public Object register(RegisterModel registerModel) {
	      
	        return registerMapper.register(registerModel);
	    }

	
	
	
}
