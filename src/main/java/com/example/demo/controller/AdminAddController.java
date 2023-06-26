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
	
	//インスタンス化
	@Resource AdminAddService adminAddService;
	@PostMapping("/adminadd")
	//管理者追加機能
	public ResponseEntity<?> adminAdd(@RequestBody AdminAddModel adminAddModel,ResponseModel responseModel) {
		
		try 
		{
			  String password = generateRandomPassword(8);
	        
	        // パスワードをregisterModelにセット
			  adminAddModel.setPassword(password);
      
        	// adminAddService.adminAddの呼び出し
			 adminAddService.adminAdd(adminAddModel);
			 //responseの値をセット
	        responseModel.setCode(200);
	        responseModel.setStatus("OK");
	        responseModel.setInformation("登録できました");
	        responseModel.setAdminAddData(adminAddModel);
	        
	        //セットされた値を返す
	        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
	     // メールアドレスが重複している場合の処理
	     //サービスからDuplicateFormatFlagsExceptionをcatchした場合ここに入る
		} catch (DuplicateFormatFlagsException ex) {
			
			//エラーメッセージをセット
			responseModel.setCode(400);
			responseModel.setStatus("ERROR");
			responseModel.setInformation("既に登録されたメールアドレスです");
			responseModel.setAdminAddData(adminAddModel);
			 
			//セットされた値を返す
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
		} catch (Exception ex) {
			// その他の例外が発生した場合の処理
			log.error("ユーザー登録エラー: ", ex);
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//ランダムパスワード生成
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
