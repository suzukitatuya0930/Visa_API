package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.GetRoleModel;

@Mapper
@Repository
public interface GetRoleMapper {

	List<GetRoleModel> getRole(GetRoleModel getRoleModel);

}
