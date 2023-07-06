package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.com.ApiResponse;
import com.example.demo.com.ExceptionHandler;
import com.example.demo.com.ResponseCode;
import com.example.demo.model.GetVisatypeModel;
import com.example.demo.service.GetVisatypeService;

@RestController

@CrossOrigin
public class GetVisatypeController {

	@Resource GetVisatypeService getVisaTypeService;

	//ビザ資格マスターテーブル取得
	@GetMapping("/getvisatype")
	public  ApiResponse<?>getVisatype(GetVisatypeModel getVisaTypeModel){
		try {
			List<GetVisatypeModel> visaTypeList = getVisaTypeService.getVisatype(getVisaTypeModel);
			if (visaTypeList != null) {

				return ApiResponse.data(ResponseCode.SUCCESS,visaTypeList);
			}else {

				return ApiResponse.code(ResponseCode.CLIENT_ERROR);
			}

		}catch (Exception ex) {


			return ExceptionHandler.handleException(ex);
		}

	}


}


