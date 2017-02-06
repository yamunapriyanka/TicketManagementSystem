package com.yamuna.service;


import com.yamuna.exception.PersistantException;
import com.yamuna.exception.ServiceException;
import com.yamuna.model.Employee;
import com.yamuna.model.Issue;
import com.yamuna.model.UserInfo;

public class TestCreateTicketService {

	/**
	 * @param args
	 * @throws ServiceException
	 * @throws PersistenceException
	 */
	public static void main(String[] args) throws ServiceException, PersistantException {

		TestCreateTicketService cts=new TestCreateTicketService();
		//CreateTicketDAO createTicket=new CreateTicketDAO();
		UserInfo user=new UserInfo();
		//user.setId(3);
		//int userId=user.getId();
	//	user.setName("Rahul");
		user.setEmailid("rasik@gmail.com");
		user.setPassword("abc123");
		
		Issue issue=new Issue();
		issue.setId(14);
		int issueId=issue.getId();
		
	/*	String subject="Login Failure";
		String description="I could not login on fb platform";
		String department="HR";
		String priority="High";*/
		
		Employee employee=new Employee();
		employee.setEmailId("xyz@gmail.com");
		employee.setPassword("abc321");
		
		//cts.registration(user.getName(), user.getEmailId(),user.getPassword());
		//cts.createTicket(user.getEmailId(),user.getPassword(), subject, description, department, priority);
		//cts.updateTicket(user.getEmailId(),user.getPassword(), issueId, description);
		//cts.updateClose(user.getEmailId(),user.getPassword(),issueId);
		//cts.findUserDetails(user.getEmailId(),user.getPassword());
		//cts.assignEmployee(employee.getEmailId(),employee.getPassword(), issueId, 4);
		//cts.ticketSolution(employee.getEmailId(),employee.getPassword(), issueId, "First pay my money");
		//cts.deleteTickets(employee.getEmailId(),employee.getPassword(), 14);
		//cts.findEmployeeTickets(employee.getEmailId(),employee.getPassword());
	}

}
