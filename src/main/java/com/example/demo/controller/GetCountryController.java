package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.com.ApiResponse;
import com.example.demo.com.ExceptionHandler;
import com.example.demo.com.ResponseCode;
import com.example.demo.model.GetCountryModel;
import com.example.demo.service.GetCountryService;

@RestController

@CrossOrigin
public class GetCountryController {

	//インスタンス化
	@Resource GetCountryService getCountryService;
	//国籍マスターテーブル取得
	@GetMapping("/getcountry")
	public   ApiResponse<?> getCountry(GetCountryModel getCountryModel){

		try {


			List<GetCountryModel> countryList = getCountryService.getCountry(getCountryModel);


			if (countryList != null) {

				return ApiResponse.data(ResponseCode.SUCCESS,countryList);
			}else {

				return ApiResponse.code(ResponseCode.CLIENT_ERROR);
			}

		}catch (Exception ex) {


			return ExceptionHandler.handleException(ex);
		}

	}
}








