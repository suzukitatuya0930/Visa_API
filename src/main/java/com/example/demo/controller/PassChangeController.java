package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PassChangeModel;
import com.example.demo.model.response.ResponseModel;
import com.example.demo.service.PassChangeService;
//@RestController
//@CrossOrigin
//public class PassChangeController {
//	
//	
//	@Resource
//	private PassChangeService passChangeService;
//	
//	@PostMapping("/passchange")
//    public ResponseEntity<?> passChange(@RequestBody PassChangeModel passChangeModel) {
//		List<PassChangeModel> a = passChangeService.selectUser(passChangeModel);
//    	System.out.println(a.size());
//    	if(a.size()!=0) {
//    		if(passChangeModel.getNewpassword().equals(passChangeModel.getConfirmpassword())) {
//    			int rowsUpdated = passChangeService.passChange(passChangeModel); 
//        if (rowsUpdated == 1) {
//            return ResponseEntity.ok("パスワード変更を変更しました。");
//            
//        } else {
//        	
//            return ResponseEntity.status(400).body("パスワード変更が失敗しました。");
//        }
//    		}else {
//    			
//    			return ResponseEntity.status(400).body("新しいパスワードと確認用パスワードが同じではありません。");
//    		}
//    		
//        
//    	}else {
//    		return ResponseEntity.status(400).body("メールとパスワードが一致しません。");
//    	}
//    	
//    }
//}
	


@RestController
@CrossOrigin
public class PassChangeController {
    
    @Resource
    private PassChangeService passChangeService;
    
    @PostMapping("/passchange")
    public ResponseEntity<?> passChange(@RequestBody PassChangeModel passChangeModel) {
        ResponseModel responseModel = new ResponseModel(); // レスポンスモデルを作成
        
        if (passChangeModel.getNewpassword().equals(passChangeModel.getConfirmpassword())) {
            int rowsUpdated = passChangeService.passChange(passChangeModel);
            
            if (rowsUpdated == 1) {
                responseModel.setCode(200);
                responseModel.setStatus("OK");
    	        responseModel.setInformation("パスワードの変更に成功しました。");
                return ResponseEntity.status(HttpStatus.OK).body(responseModel);
            } else {
                responseModel.setCode(400);
                responseModel.setStatus("OK");
    	        responseModel.setInformation("パスワードの変更に失敗しました");
               
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
            }
        } else {
            responseModel.setCode(400);
            responseModel.setStatus("OK");
	        responseModel.setInformation("新しいパスワードと確認用パスワードが同じではありません。");
          
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
        }
    }
}


