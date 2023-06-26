package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PassChangeModel;

@Mapper
@Repository
public interface PassChangeMapper {
	
	
	int passChange(PassChangeModel passChangeModel);

	List<PassChangeModel> selectUser(PassChangeModel passChangeModel);
	
}
