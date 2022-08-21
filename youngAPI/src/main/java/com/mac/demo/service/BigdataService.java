package com.mac.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mac.demo.mappers.BigdataMapper;

@Service
public class BigdataService {

	@Autowired
	private BigdataMapper dao;
	
	
	//시 데이터 가져오기
	public List<String> getsi() {
		return dao.getsi();
	}


	public List<String> getdong(String si) {
		return dao.getdong(si);
	}


	public List<String> getgil(String dong) {
		return dao.getgil(dong);
	}

}
