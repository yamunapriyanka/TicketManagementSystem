package com.yamuna.Validator;

import com.yamuna.exception.ValidatorException;
import com.yamuna.util.Validator;

public class CreateTicketValidator {

	Validator validator=new Validator();
	public void registration(String name,String emailId,String password) throws ValidatorException{
		Validator.isInvalid(name, "NAME");
		Validator.isInvalid(emailId, "EMAILID");
		Validator.isInvalid(password, "PASSWORD");
	}
	public void createTicket(String emailId,String password,String subject,String description,String department,String priority) throws ValidatorException{
	
		Validator.isInvalid(emailId, "EMAIL");
		Validator.isInvalid(password, "PASSWORD");
		Validator.isInvalid(subject, "SUBJECT");
		Validator.isInvalid(description, "DESCRIPTION");
		Validator.isInvalid(department, "DEPARTMENT");
		Validator.isInvalid(priority, "PRIORITY");
	}
	public void updateTicket(String emailId,String password,int issueId,String updateName) throws ValidatorException{
		
		Validator.isInvalid(emailId, "EMAIL");
		Validator.isInvalid(password, "PASSWORD");
		Validator.isInvalid(issueId, "ID");
		Validator.isInvalid(updateName, "DESCRIPTION");
	}
	
	public void updateClose(String emailId,String password,int issueId) throws ValidatorException{
		
		Validator.isInvalid(emailId, "EMAIL");
		Validator.isInvalid(password, "PASSWORD");
		Validator.isInvalid(issueId, "ID");
		
	}
	
	public void findUserDetails(String emailId,String password) throws ValidatorException{
		
		Validator.isInvalid(emailId, "EMAIL");
		Validator.isInvalid(password, "PASSWORD");
		
	}
	public void login(String emailId, String password) throws ValidatorException {
		// TODO Auto-generated method stubpublic void login(String emailId,String password) throws ValidatorException{
		validator.isInvalid(emailId, "EMAIL_ID");
		validator.isInvalid(password, "PASSWORD");
		
	}

	public void assignEmployee(String emailId, String password, int issueId, int employeeId) throws ValidatorException{
		
		validator.isInvalid(emailId, "EMAIL");
		validator.isInvalid(password, "PASSWORD");
		validator.isInvalid(issueId, "ISSUE_ID");
		validator.isInvalid(employeeId, "EMPLOYEE_ID");
	}
	
	public void ticketSolution(String emailId, String password, int issueId, String ticketSolution) throws ValidatorException{
		
		validator.isInvalid(emailId, "EMAIL");
		validator.isInvalid(password, "PASSWORD");
		validator.isInvalid(issueId, "ISSUE_ID");
		validator.isInvalid(ticketSolution, "SOLUTION");
	}
	public  void findEmployeeTickets(String emailId, String password) throws ValidatorException{
		validator.isInvalid(emailId, "EMAIL");
		validator.isInvalid(password, "PASSWORD");
	}
	public void deleteTickets(String emailId, String password, int issueId) throws ValidatorException{
		validator.isInvalid(emailId, "EMAIL");
		validator.isInvalid(password, "PASSWORD");
		validator.isInvalid(issueId, "ISSUE_ID");
	}
}