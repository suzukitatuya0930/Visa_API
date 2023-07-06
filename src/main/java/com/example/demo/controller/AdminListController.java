package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.com.ApiResponse;
import com.example.demo.com.ExceptionHandler;
import com.example.demo.com.ResponseCode;
import com.example.demo.model.AdminListModel;
import com.example.demo.service.AdminListService;

@RestController

@CrossOrigin
public class AdminListController {

	//インスタンス化
	@Resource AdminListService adminListService;
	//管理者の一覧を表示
	@GetMapping("/adminlist")
	public ApiResponse<?> adminList(AdminListModel adminListModel){
		try {


			List<AdminListModel> adminList = adminListService.adminList(adminListModel);


			if (adminList != null) {

				return ApiResponse.data(ResponseCode.SUCCESS,adminList);
			}else {

				return ApiResponse.code(ResponseCode.NOT_FOUND);
			}

		}catch (Exception ex) {


			return ExceptionHandler.handleException(ex);
		}

	}
}


