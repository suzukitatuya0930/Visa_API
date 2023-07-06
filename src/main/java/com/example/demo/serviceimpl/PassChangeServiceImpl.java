package com.example.demo.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.PassChangeMapper;
import com.example.demo.model.PassChangeModel;
import com.example.demo.service.PassChangeService;

@Service

public class PassChangeServiceImpl implements PassChangeService{
	
	@Resource PassChangeMapper passChangeMapper;

	
	
	
	@Override
	public List<PassChangeModel> selectUser(PassChangeModel passChangeModel) {
		// TODO 自動生成されたメソッド・スタブ
		return passChangeMapper.selectUser(passChangeModel);
	}
	@Override
	public int passChange(PassChangeModel passChangeModel) {
		// TODO 自動生成されたメソッド・スタブ
		return passChangeMapper.passChange(passChangeModel);
	}

	
	
	

}
