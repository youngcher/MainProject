package com.mac.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BigdataMapper {

	List<String> getsi();

	List<String> getdong(String si);

	List<String> getgil(String dong);

}
