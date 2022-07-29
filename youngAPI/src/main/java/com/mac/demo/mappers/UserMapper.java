package com.mac.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mac.demo.model.User;
import com.mac.demo.model.Young;


@Mapper
public interface UserMapper {

//	계정CRUD

	//계정리스트
	List<User> getList();
	//계정추가
	int add(User user);
	//계정정보
	User getOne(String nick);
	//계정삭제
	boolean deleted(String nickNameMac);
	
	
	
}
