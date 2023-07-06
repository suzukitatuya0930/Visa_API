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
import com.example.demo.model.AdminAddModel;
import com.example.demo.service.AdminAddService;
import com.example.demo.service.CheckEmailExistssService;

@RestController
@CrossOrigin
public class AdminAddController {
	
	
	@Resource AdminAddService adminAddService;
	@Resource CheckEmailExistssService checkEmailExistssService;
	@PostMapping("/adminadd")
	//管理者追加機能
	public ApiResponse<?> adminAdd(@RequestBody @Validated AdminAddModel adminAddModel, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
	        // エラーメッセージの取得と処理
	        List<String> errorMessages = bindingResult.getAllErrors().stream()
	                .map(DefaultMessageSourceResolvable::getDefaultMessage)
	                .collect(Collectors.toList());

	        return ApiResponse.data(ResponseCode.CLIENT_ERROR, errorMessages);
	    }
		
		try {
	        if (checkEmailExistssService.checkEmailExists(adminAddModel.getEmail())) {
	            // メールアドレスが重複している場合の処理
	            return ApiResponse.code(ResponseCode.CONFLICT_ERROR);
	        }
	      
	        String password = PasswordGenerator.generateRandomPassword(8);
	        
	        
	        adminAddModel.setPassword(password);
	        adminAddService.adminAdd(adminAddModel);
	        
	        
	      
	        return ApiResponse.data(ResponseCode.SUCCESS, adminAddModel);
	        
	    } catch (Exception ex) {
	    	
	
	    	 return ExceptionHandler.handleException(ex);
	    }
	}
}