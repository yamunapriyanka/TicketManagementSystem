package com.yamuna.model;

public class TestUserInfo {
	public static void main(String[] args) {
	UserInfo userInfo = new UserInfo();
	userInfo.setId(4);
	userInfo.setName("Solai");
	userInfo.setEmailid("solai@gmail.com");
	userInfo.setPassword("solai12");
	System.out.println(userInfo.getId()+""+userInfo.getName()+""+userInfo.getEmailid()+""+userInfo.getPassword());
	
	}

}

