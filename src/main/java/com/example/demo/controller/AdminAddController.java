package com.example.demo.controller;

import java.util.DuplicateFormatFlagsException;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AdminAddModel;
import com.example.demo.model.response.ResponseModel;
import com.example.demo.service.AdminAddService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class AdminAddController {
	
	@Resource AdminAddService adminAddService;
	@PostMapping("/adminadd")
	public ResponseEntity<?> adminAdd(@RequestBody AdminAddModel adminAddModel,ResponseModel responseModel) {
		
		try 
		{
			  String password = generateRandomPassword(8);
	        
	        // パスワードをregisterModelにセット
			  adminAddModel.setPassword(password);
      
        	
			  adminAddService.adminAdd(adminAddModel);
	        responseModel.setCode(200);
	        responseModel.setStatus("OK");
	        responseModel.setInformation("登録できました");
	        responseModel.setAdminAddData(adminAddModel);
	        
	        log.info("{}",responseModel);
	        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
		} catch (DuplicateFormatFlagsException ex) {
			// メールアドレスが重複している場合の処理
			
			responseModel.setCode(400);
			responseModel.setStatus("ERROR");
			responseModel.setInformation("既に登録されたメールアドレスです");
			responseModel.setAdminAddData(adminAddModel);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
		} catch (Exception ex) {
			// その他の例外が発生した場合の処理
			log.error("ユーザー登録エラー: ", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	private String generateRandomPassword(int length) {
	    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder(length);
	    
	    for (int i = 0; i < length; i++) {
	        int randomIndex = random.nextInt(characters.length());
	        char randomChar = characters.charAt(randomIndex);
	        sb.append(randomChar);
	    }
	    
	    return sb.toString();
	}

}
