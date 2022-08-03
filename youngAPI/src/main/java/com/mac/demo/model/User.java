package com.mac.demo.model;


import java.sql.Date;

public class User {

	
	private int numMac;
	private String idMac;  //pk
	private String pwMac; 
	private String nickNameMac; 
	private String emailMac;
	private String genderMac;
	private Date birthMac;
	private String phoneNumMac;
	private String cityMac;
	private String townMac; 
	private String villageMac;
	private String nameMac;
	
	
	public int getNumMac() {
		return numMac;
	}
	public void setNumMac(int numMac) {
		this.numMac = numMac;
	}
	public String getIdMac() {
		return idMac;
	}
	public void setIdMac(String idMac) {
		this.idMac = idMac;
	}
	public String getPwMac() {
		return pwMac;
	}
	public void setPwMac(String pwMac) {
		int check_SC = 0;
		String[] sc = {"!","@","#","$","%"};
		for(int i=0; i<sc.length; i++) {
			if(pwMac.indexOf(sc[i]) != -1){
	            check_SC = 1;
	        }
		}
		
		if(pwMac.length() >= 6 || pwMac.length() <= 16) {
			if(check_SC == 1) {
				this.pwMac = pwMac;
			}
		}
	}
	public String getNickNameMac() {
		return nickNameMac;
	}
	public void setNickNameMac(String nickNameMac) {
		this.nickNameMac = nickNameMac;
	}
	public String getEmailMac() {
		return emailMac;
	}
	public void setEmailMac(String emailMac) {
		this.emailMac = emailMac;
	}
	public String getGenderMac() {
		return genderMac;
	}
	public void setGenderMac(String genderMac) {
		this.genderMac = genderMac;
	}
	public Date getBirthMac() {
		return birthMac;
	}
	public void setBirthMac(Date birthMac) {
		this.birthMac = birthMac;
	}
	public String getPhoneNumMac() {
		return phoneNumMac;
	}
	public void setPhoneNumMac(String phoneNumMac) {
		this.phoneNumMac = phoneNumMac;
	}
	public String getCityMac() {
		return cityMac;
	}
	public void setCityMac(String cityMac) {
		this.cityMac = cityMac;
	}
	public String getTownMac() {
		return townMac;
	}
	public void setTownMac(String townMac) {
		this.townMac = townMac;
	}
	public String getVillageMac() {
		return villageMac;
	}
	public void setVillageMac(String villageMac) {
		this.villageMac = villageMac;
	}
	public String getNameMac() {
		return nameMac;
	}
	public void setNameMac(String nameMac) {
		this.nameMac = nameMac;
	}
	

}
