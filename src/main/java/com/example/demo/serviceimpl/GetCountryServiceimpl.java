package com.example.demo.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.GetCountryMapper;
import com.example.demo.model.GetCountryModel;
import com.example.demo.service.GetCountryService;
@Service
public class GetCountryServiceimpl implements GetCountryService{
	@Resource GetCountryMapper getCountryMapper;
	
	@Override
	public List<GetCountryModel> getCountry(GetCountryModel getCountryModel) {
		// TODO 自動生成されたメソッド・スタブ
		return getCountryMapper.getCountry(getCountryModel);
	}

}
