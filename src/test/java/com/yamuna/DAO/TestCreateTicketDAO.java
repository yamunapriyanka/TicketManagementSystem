package com.yamuna.DAO;
import com.yamuna.exception.PersistantException;
import com.yamuna.exception.ServiceException;
import com.yamuna.model.Issue;
import com.yamuna.model.UserInfo;

public class TestCreateTicketDAO {

	public static void main(String[] args) throws  ServiceException, PersistantException {

		CreateTicketDAO createTicket=new CreateTicketDAO();
		UserInfo userinfo=new UserInfo();
		//userinfo.setId(3);
	//	Int userId=userinfo.getId();
		userinfo.setEmailid("yamuna@gmail.com");
		userinfo.setPassword("yamuna123");
		
		Issue issue=new Issue();
		issue.setId(12);
    	int issueId=issue.getId();
		
//		String subject="LOGIN FAULT";
		String description="DISPLAY NOT WORKING";
//		String department="Finance";
//		String priority="High";
	//createTicket.createTicket(userinfo.getEmailid(),userinfo.getPassword(), subject, description, department, priority);
		createTicket.updateTicket(userinfo.getEmailid(),userinfo.getPassword(), issueId, description);
		//createTicket.updateClose(user.getEmailId(),user.getPassword(),issueId);
	//createTicket.findUserDetails(user.getEmailId(),user.getPassword());
		
//		Employee employee=new Employee();
//		employee.setId(2);
//		employee.setEmailId("mumtaj@gmail.com");
//		employee.setPassword("mumtaj123");
		//Solution solution=new Solution();
		
		//solution.setSolutionDescription("Check you internet connection");
	
		//createTicket.assignEmployee(employee.getEmailId(), employee.getPassword(), issueId,);
		//createTicket.ticketSolution(employee.getEmailId(), employee.getPassword(), issueId, solution.getResolutionDescription());
		//createTicket.findEmployeeTickets(employee.getEmailId(), employee.getPassword());
		//createTicket.deleteTickets(employee.getEmailId(), employee.getPassword(), issueId);
		//IssueDAO issueDao=new IssueDAO();
		//issueDao.findempTickets(employee);
		/*List<Issue> list = issueDao.findempTickets(1);
		Iterator<Issue> i = list.iterator();
		while (i.hasNext()) {
			Issue issues = (Issue) i.next();
			System.out.println(issues.getId()+ "\t" +issues.getSubject() + "\t"
					+ issues.getDescription() +"\t"+issues.getStatus());
		}
*/
	//	issueDao.findempTickets(employee);
		
	/*	List<Solution> list = solDao.findempTickets();
		Iterator<Solution> i = list.iterator();
		while (i.hasNext()) {
			Solution sol = (Solution) i.next();
			System.out.println(list);
		}*/
	}
	}	
