package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminListModel {
	
	 private String email;
	 private String first_name;
	 private String middle_name;
	 private String last_name;
	 private String role_name;

}
