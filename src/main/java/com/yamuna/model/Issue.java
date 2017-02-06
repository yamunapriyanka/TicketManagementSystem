package com.yamuna.model;

import lombok.Data;

@Data
public class Issues {
	
	private int id;
	private TicketTransaction transactionid;
	private String question;
	private String subject;
	private String Solution;
	
}
