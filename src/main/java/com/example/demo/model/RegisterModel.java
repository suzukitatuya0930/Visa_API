package com.example.demo.model;

import java.sql.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RegisterModel {
	
	
	@NotEmpty(message = "{NotEmpty.message}")
	@Pattern(regexp = "^[\\w.%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$", message = "{Pattern.email.message}")
	 private String email;
	
	@NotEmpty(message = "{NotEmpty.message}")
	@Pattern(regexp = "^[A-Z]*$", message = "{Pattern.uppercasename.message}")
    @Size(min = 1, max = 50, message = "{Size.name.message}")
	 private String first_name;
	
	@Pattern(regexp = "^[A-Z]*$", message = "{Pattern.uppercasename.message}")
    @Size(min = 1, max = 50, message = "{Size.name.message}")
	 private String middle_name;
	
	@NotEmpty(message = "{NotEmpty.message}")
	@Pattern(regexp = "^[A-Z]*$", message = "{Pattern.uppercasename.message}")
    @Size(min = 1, max = 50, message = "{Size.name.message}")
	 private String last_name;
	
	
	@NotEmpty(message = "{NotEmpty.message}")
	@Pattern(regexp = "^[ァ-ヶー々]*$", message = "{Pattern.kananame.message}")
	@Size(min = 1, max = 50, message = "{Size.name.message}")
	 private String first_name_kana;
	
	 private String middle_name_kana;
	
	@NotEmpty(message = "{NotEmpty.message}")
	@Pattern(regexp = "^[ァ-ヶー々]*$", message = "{Pattern.kananame.message}")
	@Size(min = 1, max = 50, message = "{Size.name.message}")
	 private String last_name_kana;
	
	
	@Pattern(regexp = "^[一-龠]*$", message = "{Pattern.kanziname.message}")
	@Size(min = 1, max = 50, message = "{Size.name.message}")
	 private String first_name_kanzi;
	
	@Pattern(regexp = "^[一-龠]*$", message = "{Pattern.kanziname.message}")
	@Size(min = 1, max = 50, message = "{Size.name.message}")
	 private String last_name_kanzi;
	
	@NotEmpty(message = "{NotEmpty.message}")
	 private String visatype_id;
	
	 @NotNull(message = "{NotEmpty.message}")
	 @Future(message = "{Future.message}")
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 
	 @NotEmpty(message = "{NotEmpty.message}")
	 private Date visa_date;
	 private String country_id;
	 private String password;
	 private String role_id;

}
