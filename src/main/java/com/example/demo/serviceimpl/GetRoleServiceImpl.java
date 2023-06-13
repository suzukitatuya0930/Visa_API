package com.example.demo.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.GetRoleMapper;
import com.example.demo.model.GetRoleModel;
import com.example.demo.service.GetRoleService;

@Service
public class GetRoleServiceImpl implements GetRoleService{
	@Resource GetRoleMapper getRoleMapper;

	@Override
	public List<GetRoleModel> getRole(GetRoleModel getRoleModel) {
		// TODO 自動生成されたメソッド・スタブ
		return getRoleMapper.getRole(getRoleModel);
	}
	

}
