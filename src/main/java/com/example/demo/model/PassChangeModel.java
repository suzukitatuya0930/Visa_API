package com.example.demo.model;

import lombok.Data;

@Data
public class PassChangeModel {
	
	private String email;
    private String password;
    private String newpassword;
    private String confirmpassword;
    
    
}