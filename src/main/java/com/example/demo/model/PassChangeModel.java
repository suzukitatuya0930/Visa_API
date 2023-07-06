package com.example.demo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PassChangeModel {
	
	private String email;
	@NotEmpty(message = "NotEmpty.message")
	@Size(min = 6, max = 25, message = "Size.password.message")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$", message = "Pattern.password.message")
    private String password;
	@NotEmpty(message = "NotEmpty.message")
	@Size(min = 6, max = 25, message = "Size.password.message")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$", message = "Pattern.password.message")
    private String newpassword;
	@NotEmpty(message = "NotEmpty.message")
	@Size(min = 6, max = 25, message = "Size.password.message")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$", message = "Pattern.password.message")
    private String confirmpassword;
    
    
}