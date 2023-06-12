package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AdminAddModel;

@Repository
@Mapper
public interface AdminAddMapper {
	
	int adminAdd(AdminAddModel adminAddModel);
	
	boolean checkEmailExists(String email);

}
