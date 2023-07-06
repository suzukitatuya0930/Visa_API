package com.example.demo.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.CheckEmailExistsMapper;
import com.example.demo.service.CheckEmailExistssService;
@Service
public class CheckEmailExistsServiceImpl implements CheckEmailExistssService {

	@Resource CheckEmailExistsMapper checkEmailExistsMapper;
	
	@Override
	public boolean checkEmailExists(String email) {
		// TODO 自動生成されたメソッド・スタブ
		return checkEmailExistsMapper.checkEmailExists(email);
	}

}
