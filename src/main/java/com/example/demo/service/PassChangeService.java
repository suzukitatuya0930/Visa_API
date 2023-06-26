package com.example.demo.service;

import java.util.List;

import com.example.demo.model.PassChangeModel;

public interface PassChangeService {
	
	int passChange(PassChangeModel passChangeModel);

	
	List<PassChangeModel> selectUser(PassChangeModel passChangeModel);

}
