package com.example.demo.model.response;

import java.util.List;

import com.example.demo.model.AdminAddModel;
import com.example.demo.model.RegisterModel;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
@Data
public class ResponseModel {

	
	private int code;
	private String status;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String information;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> errorlist;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private RegisterModel registerData;
//	@JsonInclude(JsonInclude.Include.NON_NULL)
//	private LoginModel logindata;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private AdminAddModel adminAddData;
}
