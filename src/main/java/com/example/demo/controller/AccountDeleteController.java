package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.com.ApiResponse;
import com.example.demo.com.ExceptionHandler;
import com.example.demo.com.ResponseCode;
import com.example.demo.model.AccountDeleteModel;
import com.example.demo.service.AccountDeleteService;


@RestController
@CrossOrigin

public class AccountDeleteController {

	@Resource
	AccountDeleteService accountDeleteService;

	@DeleteMapping("/accountdelete")
	public ApiResponse<?> accountDelete(@RequestBody AccountDeleteModel accountDeleteModel) {
		try {
		int userDelete = accountDeleteService.accountDelete(accountDeleteModel);

		if (userDelete == 1) {

		
			return ApiResponse.code(ResponseCode.SUCCESS);

		} else {

		
			return ApiResponse.code(ResponseCode.CLIENT_ERROR);
		}

		  }catch (Exception ex) {
		    	
				
		    	 return ExceptionHandler.handleException(ex);
		    }
		
		}
}

	
