package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AdminListModel;

public interface AdminListService {
	
	List<AdminListModel>adminList(AdminListModel adminListModel);

	List<AdminListModel> adminCheck(AdminListModel adminListModel);

}
