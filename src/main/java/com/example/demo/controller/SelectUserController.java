package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SelectUserModel;
import com.example.demo.model.response.ResponseModel;
import com.example.demo.service.SelectUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class SelectUserController {
	@Resource
	SelectUserService selectUserService;
	//ユーザー詳細情報表示
	@GetMapping("/user/{email}")
	public ResponseEntity<?> selectUser(ResponseModel responseModel,SelectUserModel selectUserModel){
		List<SelectUserModel> user = selectUserService.selectUser(selectUserModel);
		if(user.size()!=0) {
			return ResponseEntity.status(HttpStatus.OK).body(user);
	}else {
		
		responseModel.setCode(400);
		responseModel.setStatus("ERROR");
		responseModel.setInformation("存在しないユーザーです");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
	}
		
	}
	

}
