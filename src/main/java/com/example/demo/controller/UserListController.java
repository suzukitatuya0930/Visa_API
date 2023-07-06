package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.com.ApiResponse;
import com.example.demo.com.ExceptionHandler;
import com.example.demo.com.ResponseCode;
import com.example.demo.model.UserListModel;
import com.example.demo.service.UserListService;

@RestController

@CrossOrigin
public class UserListController {
	
	@Resource UserListService userListService;
	//ユーザー一覧表示
	@GetMapping("/userlist")
	public ApiResponse<?> userList(UserListModel userListModel){
		try {
			List<UserListModel> userList = userListService.userList(userListModel);

			if(userList != null ) {
				return ApiResponse.data(ResponseCode.SUCCESS,userList);

			}else {
				return ApiResponse.code(ResponseCode.CONFLICT_ERROR);
			}
		}catch (Exception ex) {
			return ExceptionHandler.handleException(ex);

		}

	}
}







