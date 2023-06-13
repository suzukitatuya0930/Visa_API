package com.example.demo.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.GetVisatypeMapper;
import com.example.demo.model.GetVisatypeModel;
import com.example.demo.service.GetVisatypeService;

@Service
public class GetVisatypeServiceImpl implements GetVisatypeService{

	@Resource GetVisatypeMapper getVisaTypeMapper;
	
	@Override
	public List<GetVisatypeModel> getVisatype(GetVisatypeModel getVisaTypeModel) {
		// TODO 自動生成されたメソッド・スタブ
		return getVisaTypeMapper.getVisatype(getVisaTypeModel);
	}

	
}
