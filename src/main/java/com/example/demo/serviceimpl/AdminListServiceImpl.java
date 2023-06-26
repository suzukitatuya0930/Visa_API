package com.example.demo.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.AdminListMapper;
import com.example.demo.model.AdminListModel;
import com.example.demo.service.AdminListService;

@Service
public class AdminListServiceImpl implements AdminListService{
	
	@Resource AdminListMapper adminListMapper;
	
	
	public List<AdminListModel> adminList(AdminListModel adminListModel) {
		
		 return adminListMapper.adminList(adminListModel);
    }


	@Override
	public List<AdminListModel> adminCheck(AdminListModel adminListModel) {
		// TODO 自動生成されたメソッド・スタブ
		return adminListMapper.adminList(adminListModel);
	}

}
