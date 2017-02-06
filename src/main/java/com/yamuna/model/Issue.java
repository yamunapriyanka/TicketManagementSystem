package com.yamuna.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Issue {
	
	private int id;
	private UserInfo USER_ID;
	private Department DEPARTMENT_ID;
	private String SUBJECT;
    private String DESCRIPTION;
    private LocalDateTime CREATED_DATE;
	private LocalDateTime RESOLVED_DATE;
	private String STATUS;	
	private String PRIORITY;
	
}
