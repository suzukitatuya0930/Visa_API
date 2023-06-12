package com.example.demo.serviceimpl;

import java.util.DuplicateFormatFlagsException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.AdminAddMapper;
import com.example.demo.model.AdminAddModel;
import com.example.demo.service.AdminAddService;

@Service
public class AdminAddServiceImpl implements AdminAddService {
	
	@Resource
	AdminAddMapper adminAddMapper;
	
	@Override
	public Object adminAdd(AdminAddModel adminAddModel) {
	        // メールアドレスの重複チェック
	        boolean emailExists = adminAddMapper.checkEmailExists(adminAddModel.getEmail());
	        if (emailExists) {
	            throw new DuplicateFormatFlagsException("既に登録されたメールアドレスです");
	        }
	        // ユーザーの登録
	        return adminAddMapper.adminAdd(adminAddModel);
	    }

}
