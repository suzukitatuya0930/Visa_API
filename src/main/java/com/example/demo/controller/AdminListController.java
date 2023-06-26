package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AdminListModel;
import com.example.demo.service.AdminListService;

@RestController

@CrossOrigin
public class AdminListController {
	
	//インスタンス化
	@Resource AdminListService adminListService;
	//管理者の一覧を表示
	@GetMapping("/adminlist")
	public ResponseEntity<?> adminList(AdminListModel adminListModel){
		//adminListService.adminListの呼び出し
		List<AdminListModel> admincheck = adminListService.adminCheck(adminListModel);
		boolean isAdmin = admincheck.stream().anyMatch(u -> "ADMIN".equals(u.getRole_name()) || "LEADERADMIN".equals(u.getRole_name()));
		if (isAdmin) 
			{
		    List<AdminListModel> adminList = adminListService.adminList(adminListModel);
		    	return ResponseEntity.ok(adminList);
			}  else {
		        return ResponseEntity.status(400).body("ERROR");
	 
	

}
}
}


