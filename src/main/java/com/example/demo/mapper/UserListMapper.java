package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserListModel;

@Repository
@Mapper
public interface UserListMapper {
	
	List<UserListModel>userList(UserListModel userListModel);

	

}
