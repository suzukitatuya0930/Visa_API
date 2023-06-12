package com.example.demo.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserListMapper;
import com.example.demo.model.UserListModel;
import com.example.demo.service.UserListService;

@Service
public class UserListServiceImpl implements UserListService {

	@Resource
	UserListMapper userListMapper;
	
	@Override
	public List<UserListModel> userList(UserListModel userListModel) {
		
		 return userListMapper.userList(userListModel);
    }

	
	@Override
	public List<UserListModel> adminCheck(UserListModel userListModel) {
		// TODO 自動生成されたメソッド・スタブ
		 return userListMapper.adminCheck(userListModel);
	}
	
}


