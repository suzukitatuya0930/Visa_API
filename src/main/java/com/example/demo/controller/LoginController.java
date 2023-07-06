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
import com.example.demo.com.ResponseCode;
import com.example.demo.model.LoginModel;
import com.example.demo.service.LoginService;

/**
 * @author 鈴木達也
 *
 */
@RestController

@CrossOrigin

public class LoginController {
	
	
	@Resource LoginService loginService;
	
	@PostMapping("/login")
	public ApiResponse<?> login(@RequestBody @Validated  LoginModel loginModel, BindingResult bindingResult) {
		
		 if (bindingResult.hasErrors()) {
		        // エラーメッセージの取得と処理
		        List<String> errorMessages = bindingResult.getAllErrors().stream()
		                .map(DefaultMessageSourceResolvable::getDefaultMessage)
		                .collect(Collectors.toList());

		        return ApiResponse.data(ResponseCode.CLIENT_ERROR, errorMessages);
		    }
		
		try {		
			String email = loginModel.getEmail();
			String password = loginModel.getPassword();
			LoginModel user = loginService.login(loginModel);
		
		if (user != null && user.getPassword().equals(password)) {
			LoginModel login = new LoginModel();
		        	
			login.setEmail(email);
			login.setRole_name(user.getRole_name());
		  
				
				return ApiResponse.data(ResponseCode.SUCCESS,login);
		} else {
	
			 	//エラー処理
				return ApiResponse.code(ResponseCode.CLIENT_ERROR);
		        }
		}catch (Exception ex) {


			return ExceptionHandler.handleException(ex);
		}
	
}
}
	    

