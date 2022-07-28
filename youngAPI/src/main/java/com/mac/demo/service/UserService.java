package com.mac.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mac.demo.mappers.UserMapper;
import com.mac.demo.model.User;

@Service
public class UserService {

	//유저 맵퍼
	@Autowired
	private UserMapper dao;

	public boolean add(User user) {
		return dao.add(user) > 0;
	}

	public List<User> getList() {
		
		return dao.getList();
	}
	
	
	
}
