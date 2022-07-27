package com.mac.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Young {
	
	private int userid;
	private String userName;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
