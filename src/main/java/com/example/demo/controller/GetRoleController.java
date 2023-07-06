package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.com.ApiResponse;
import com.example.demo.com.ExceptionHandler;
import com.example.demo.com.ResponseCode;
import com.example.demo.model.GetRoleModel;
import com.example.demo.service.GetRoleService;

@RestController

@CrossOrigin
public class GetRoleController {


	@Resource GetRoleService getRoleService;
	//roleマスターテーブル取得
	@GetMapping("/getrole")
	public  ApiResponse<?>getRole(GetRoleModel getRoleModel){
		//getRoleService.getRoleの呼び出し
		try {
			List<GetRoleModel> roleList = getRoleService.getRole(getRoleModel);
			if (roleList != null) {

				return ApiResponse.data(ResponseCode.SUCCESS,roleList);
			}else {

				return ApiResponse.code(ResponseCode.CLIENT_ERROR);
			}

		}catch (Exception ex) {


			return ExceptionHandler.handleException(ex);
		}

	}
}