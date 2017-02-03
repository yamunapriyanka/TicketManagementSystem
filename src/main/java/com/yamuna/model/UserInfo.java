package com.yamuna.model;

import lombok.Data;

@Data
public class UserInfo {
	
	private int id;
	private String name;
	private String emailid;
	private String password;
	private boolean isactive;

}
