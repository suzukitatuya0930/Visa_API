package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.com.ApiResponse;
import com.example.demo.com.ExceptionHandler;
import com.example.demo.com.ResponseCode;
import com.example.demo.model.SelectUserModel;
import com.example.demo.service.SelectUserService;

@RestController

@CrossOrigin
public class SelectUserController {
	@Resource
	SelectUserService selectUserService;
	//ユーザー詳細情報表示
	//@GetMapping("/user/{email}")
	@GetMapping("/selectuser")
	public ApiResponse<?> selectUser(@RequestBody SelectUserModel selectUserModel){
		try {
			List<SelectUserModel> user = selectUserService.selectUser(selectUserModel);

			if(user.size()!=0) {
				return ApiResponse.data(ResponseCode.SUCCESS,user);
			}else {

				return ApiResponse.code(ResponseCode.NOT_FOUND);

			}
		}catch (Exception ex) {
	    	
			
	    	 return ExceptionHandler.handleException(ex);
	    }
	}
}





