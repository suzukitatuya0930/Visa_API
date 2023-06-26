package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AccountDeleteModel;

@Mapper
@Repository

public interface AccountDeleteMapper {

	int accountDelete(AccountDeleteModel accountDeleteModel);

}
