package com.example.demo.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SelectUserModel {
	 private String email;
	 private String first_name;
	 private String middle_name;
	 private String last_name;
	 private String first_name_kana;
	 private String middle_name_kana;
	 private String last_name_kana;
	 private String first_name_kanzi;
	 private String last_name_kanzi;
	 private String visatype_name;
	 private Date visa_date;
	 private String country_name;
	 private String role_name;


}
