package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.com.ApiResponse;
import com.example.demo.com.ExceptionHandler;
import com.example.demo.com.PasswordGenerator;
import com.example.demo.com.ResponseCode;
import com.example.demo.model.RegisterModel;
import com.example.demo.service.CheckEmailExistssService;
import com.example.demo.service.RegisterService;


@RestController

@CrossOrigin
public class RegisterController {

	
	@Resource RegisterService registerService;
	@Resource CheckEmailExistssService checkEmailExistssService;
	//一般ユーザー新規登録機能
	@PostMapping("/register")
	public ApiResponse<?> register(@RequestBody @Validated  RegisterModel registerModel, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
	        // エラーメッセージの取得と処理
	        List<String> errorMessages = bindingResult.getAllErrors().stream()
	                .map(DefaultMessageSourceResolvable::getDefaultMessage)
	                .collect(Collectors.toList());

	        return ApiResponse.errordata(ResponseCode.CLIENT_ERROR, errorMessages,registerModel);
	    }
		
		try {
	        if (checkEmailExistssService.checkEmailExists(registerModel.getEmail())) {
	            // メールアドレスが重複している場合の処理
	            return ApiResponse.code(ResponseCode.CONFLICT_ERROR);
	        }
	      
	        String password = PasswordGenerator.generateRandomPassword(8);
	        
	        
	        registerModel.setPassword(password);
	        registerService.register(registerModel);
	        
	        
	      
	        return ApiResponse.data(ResponseCode.SUCCESS, registerModel);
	        
		}catch (Exception ex) {
	    	
			
	    	 return ExceptionHandler.handleException(ex);
	    }
	}
}
