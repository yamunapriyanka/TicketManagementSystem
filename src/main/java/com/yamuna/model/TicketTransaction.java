package com.yamuna.model;



import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TicketTransaction {
	private int id;
	private UserInfo userid;
	private String subject;
	private String description;
	private LocalDateTime createdDate;
	private LocalDateTime resolvedDate;
	private Department departmentId;
	private Employee employeeId;
	private String status;
}
