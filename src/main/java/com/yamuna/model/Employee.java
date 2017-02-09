package com.yamuna.model;

import lombok.Data;
@Data
public class Employee {
	
	
	private int id;
	private Role role_id;
	private Department departmentId;
	private String name;
	private String emailId;
	private String password;
	private boolean isactive;
	
	

}
