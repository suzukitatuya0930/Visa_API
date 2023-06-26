package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AccountDeleteModel;
import com.example.demo.model.response.ResponseModel;
import com.example.demo.service.AccountDeleteService;

@RestController
@CrossOrigin
public class AccountDeleteController {
	
	@Resource AccountDeleteService accountDeleteService;
	
	@PostMapping("/accountdelete/{email}")
	public ResponseEntity<?> accountDelete(ResponseModel responseModel,AccountDeleteModel accountDeleteModel){
		
		int userDelete = accountDeleteService.accountDelete(accountDeleteModel);
		
		if(userDelete ==1) {
			
			 responseModel.setCode(200);
		     responseModel.setStatus("OK");
			 responseModel.setInformation("削除できました");
			 return ResponseEntity.status(HttpStatus.OK).body(responseModel);
		}else if(userDelete!=1) {
			
			responseModel.setCode(400);
			responseModel.setStatus("ERROR");
			responseModel.setInformation("削除できませんでした");
			
			
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
		
	}
}
		
		
	
	


		
	
		
	
	



