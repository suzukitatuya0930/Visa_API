package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.com.ApiResponse;
import com.example.demo.com.ExceptionHandler;
import com.example.demo.com.ResponseCode;
import com.example.demo.model.PassChangeModel;
import com.example.demo.service.PassChangeService;

	


@RestController
@CrossOrigin
public class PassChangeController {
    
    @Resource
    private PassChangeService passChangeService;
    
    @PostMapping("/passchange")

    
    public ApiResponse<?> passChange(@RequestBody PassChangeModel passChangeModel) {
    	try {
    		
    		 if (passChangeModel.getNewpassword().equals(passChangeModel.getConfirmpassword())) {
               int rowsUpdated = passChangeService.passChange(passChangeModel);
               
               if (rowsUpdated == 1) {
                  
            	   return ApiResponse.data(ResponseCode.SUCCESS,rowsUpdated);
               } else {
                   
                  
            	   return ApiResponse.message(ResponseCode.CLIENT_ERROR,"入力されたパスワードが違います");
               }
    		   } else {
              
             
    			   return ApiResponse.message(ResponseCode.CLIENT_ERROR,"新しいパスワードと確認用パスワードが同じではありません。");
           }
       
    	}catch (Exception ex) {
    		 return ExceptionHandler.handleException(ex);
		}
	
    		
    	
    }

}


