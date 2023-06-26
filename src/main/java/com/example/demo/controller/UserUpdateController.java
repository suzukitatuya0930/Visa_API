package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserUpdateModel;
import com.example.demo.model.response.ResponseModel;
import com.example.demo.service.UserUpdateService;

@RestController
@CrossOrigin
public class UserUpdateController {
	
	@Resource UserUpdateService userUpdateService;
	@PostMapping("/userapdate")
	public ResponseEntity<?> userUpdate(@RequestBody  UserUpdateModel userUpdateModel){
		ResponseModel responseModel = new ResponseModel();
		try {
			 userUpdateService.userUpdate(userUpdateModel);
			 
			responseModel.setCode(200);
			responseModel.setStatus("OK");
			responseModel.setInformation("更新できました");
			return ResponseEntity.status(HttpStatus.OK).body(responseModel);
		} catch (Exception e) {
			responseModel.setCode(400);
			responseModel.setStatus("ERROR");
			responseModel.setInformation("更新できませんでした：");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
		}
	}
}