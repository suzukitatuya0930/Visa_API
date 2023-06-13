package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.GetVisatypeModel;
@Mapper
@Repository
public interface GetVisatypeMapper {

	List<GetVisatypeModel> getVisatype(GetVisatypeModel getVisaTypeModel);

}
