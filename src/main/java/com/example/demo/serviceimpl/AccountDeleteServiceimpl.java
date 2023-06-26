package com.example.demo.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.AccountDeleteMapper;
import com.example.demo.model.AccountDeleteModel;
import com.example.demo.service.AccountDeleteService;

@Service
public class AccountDeleteServiceimpl implements AccountDeleteService {

	
	@Resource AccountDeleteMapper accountDeleteMapper;
	
	@Override
	public int accountDelete(AccountDeleteModel accountDeleteModel) {
		// TODO 自動生成されたメソッド・スタブ
		return accountDeleteMapper.accountDelete(accountDeleteModel);
	}

}
