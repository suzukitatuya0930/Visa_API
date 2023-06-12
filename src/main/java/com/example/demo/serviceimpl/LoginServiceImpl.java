package com.example.demo.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.LoginMapper;
import com.example.demo.model.LoginModel;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	 @Resource
	    private LoginMapper loginMapper;

	@Override
	 //public List<LoginModel> Login(LoginModel loginModel) {
		public LoginModel login(LoginModel loginModel) {
		 return loginMapper.login(loginModel);
}
}
