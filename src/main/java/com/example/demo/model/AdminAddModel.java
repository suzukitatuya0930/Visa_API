package com.example.demo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AdminAddModel {
	
	 @NotEmpty(message = "{NotEmpty.message}")
	 @Pattern(regexp = "^[\\w.%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$", message = "{Pattern.email.message}")
	 private String email;
	 
	 @NotEmpty(message = "{NotEmpty.message}")
	 @Size(min = 1, max = 50, message = "{Size.name.message}")
	 @Pattern(regexp = "^[a-zA-Zぁ-んァ-ヶー一-龠々]*$", message = "{Pattern.name.message}")
	 private String first_name;
	 
	
	 @Size(min = 1, max = 50, message = "{Size.name.message}")
	 @Pattern(regexp = "^[a-zA-Zぁ-んァ-ヶー一-龠々]*$", message = "{Pattern.name.message}")
	 private String middle_name;
	 
	 @NotEmpty(message = "{NotEmpty.message}")
	 @Size(min = 1, max = 50, message = "{Size.name.message}")
	 @Pattern(regexp = "^[a-zA-Zぁ-んァ-ヶー一-龠々]*$", message = "{Pattern.name.message}")
	 private String last_name;
	 
	 @NotEmpty(message = "{NotEmpty.message}")
	 private String role_id;
	 
	 private String password;

}
