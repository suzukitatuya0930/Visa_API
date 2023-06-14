package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SelectUserModel;
@Repository
@Mapper
public interface SelectUserMapper {

	List<SelectUserModel> selectUser(SelectUserModel selectUserModel);

}
