package com.example.demo.model;

import java.sql.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserUpdateModel {
	
	
	 private String email;
	 @NotNull(message = "{NotEmpty.message}")
	 @Future(message = "{Future.message}")
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date visa_date;
	 @NotEmpty(message = "{NotEmpty.message}")
	 private String visatype_id;
	
	 
	 
	
	 
	
	

}
