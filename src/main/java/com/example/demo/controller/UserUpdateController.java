package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.com.ApiResponse;
import com.example.demo.com.ExceptionHandler;
import com.example.demo.com.ResponseCode;
import com.example.demo.model.UserUpdateModel;
import com.example.demo.service.UserUpdateService;

@RestController
@CrossOrigin
public class UserUpdateController {
	
	@Resource UserUpdateService userUpdateService;
	@PutMapping("/userapdate")
	public ApiResponse<?> userUpdate(@RequestBody @Validated  UserUpdateModel userUpdateModel ,BindingResult bindingResult){
		
		if (bindingResult.hasErrors()) {
	        // エラーメッセージの取得と処理
	        List<String> errorMessages = bindingResult.getAllErrors().stream()
	                .map(DefaultMessageSourceResolvable::getDefaultMessage)
	                .collect(Collectors.toList());

	        return ApiResponse.data(ResponseCode.CLIENT_ERROR, errorMessages);
	    }
		try {
			
			 userUpdateService.userUpdate(userUpdateModel);
			 
//			
			 return ApiResponse.data(ResponseCode.SUCCESS, userUpdateModel);
			
		} catch (Exception ex) {
//			
			return ExceptionHandler.handleException(ex);
		}
	}
}