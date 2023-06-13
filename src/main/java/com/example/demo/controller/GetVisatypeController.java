package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GetVisatypeModel;
import com.example.demo.service.GetVisatypeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class GetVisatypeController {
	
	@Resource GetVisatypeService getVisaTypeService;
	
	@GetMapping("/getvisatype")
	public  ResponseEntity<?>getVisatype(GetVisatypeModel getVisaTypeModel){
		
		List<GetVisatypeModel> visaTypeList = getVisaTypeService.getVisatype(getVisaTypeModel);
		return ResponseEntity.ok(visaTypeList);
		
	}

}
