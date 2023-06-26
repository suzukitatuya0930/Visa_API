package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserListModel;
import com.example.demo.service.UserListService;

@RestController

@CrossOrigin
public class UserListController {
	@Resource UserListService userListService;
	//ユーザー一覧表示
	@GetMapping("/userlist")
	public ResponseEntity<?> userList(UserListModel userListModel){
		
		List<UserListModel> userList = userListService.userList(userListModel);
		       return ResponseEntity.ok(userList);
		    
	}
}
	




	
	


	
	

