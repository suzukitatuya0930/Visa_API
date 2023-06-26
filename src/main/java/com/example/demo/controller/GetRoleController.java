package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GetRoleModel;
import com.example.demo.service.GetRoleService;

@RestController

@CrossOrigin
public class GetRoleController {
	

	@Resource GetRoleService getRoleService;
	//roleマスターテーブル取得
	@GetMapping("/getrole")
	 public  ResponseEntity<?>getRole(GetRoleModel getRoleModel){
		//getRoleService.getRoleの呼び出し
		List<GetRoleModel> roleList = getRoleService.getRole(getRoleModel);
		return ResponseEntity.ok(roleList);
	

}
}