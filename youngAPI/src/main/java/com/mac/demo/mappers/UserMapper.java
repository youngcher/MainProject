package com.mac.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mac.demo.model.User;
import com.mac.demo.model.Young;


@Mapper
public interface UserMapper {

//	계정CRUD
	int add(User user); //계정추가
	int edit(User user);	//계정 수정	
	boolean delete(String uid); //계정삭제
	User getMypage(String uid); //마이페이지(계정상세보기)
	

	List<User> getList(); //모든 유저리스트 확인

	int save(Young young);
	
	
	
}
