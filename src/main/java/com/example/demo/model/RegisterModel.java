package com.example.demo.model;

import java.sql.Date;

import lombok.Data;

@Data
public class RegisterModel {
	
	
	 private String email;
	 private String first_name;
	 private String middle_name;
	 private String last_name;
	 private String first_name_kana;
	 private String middle_name_kana;
	 private String last_name_kana;
	 private String first_name_kanzi;
	 private String last_name_kanzi;
	 private String visatype_id;
	 private Date visa_date;
	 private String country_id;
	 private String password;

}
