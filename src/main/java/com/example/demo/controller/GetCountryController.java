package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GetCountryModel;
import com.example.demo.service.GetCountryService;

@RestController

@CrossOrigin
public class GetCountryController {
	
	//インスタンス化
	@Resource GetCountryService getCountryService;
	//国籍マスターテーブル取得
	@GetMapping("/getcountry")
	 public  ResponseEntity<?>getCountry(GetCountryModel getCountryModel){
		//getCountryService.getCountryの呼び出し
		List<GetCountryModel> countryList = getCountryService.getCountry(getCountryModel);
		
		
		 return ResponseEntity.status(HttpStatus.OK).body(countryList);
		
		
		
	}
}
