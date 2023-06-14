package com.example.demo.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.SelectUserMapper;
import com.example.demo.model.SelectUserModel;
import com.example.demo.service.SelectUserService;

@Service
public class SelectUserServiceImpl implements SelectUserService{

	@Resource SelectUserMapper selectUserMapper;
	@Override
	public List<SelectUserModel> selectUser(SelectUserModel selectUserModel) {
		// TODO 自動生成されたメソッド・スタブ
		return selectUserMapper.selectUser(selectUserModel);
	}
	

}
