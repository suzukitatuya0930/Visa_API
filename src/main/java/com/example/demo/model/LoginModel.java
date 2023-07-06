package com.example.demo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginModel {
	
	
	
	/**
	 email 
	 */
	@NotEmpty(message = "{NotEmpty.message}")
	@Pattern(regexp = "^[\\w.%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$", message = "{Pattern.email.message}")
	
	private String email;
	
	/**パスワード */
	@NotEmpty(message = "{NotEmpty.message}")
	@Size(min = 6, max = 25, message = "{Size.password.message}")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$", message = "{Pattern.password.message}")
	private String password;
	/**権限名 */
	private String role_name;
	
	private String delete_flag;
	
	
}

