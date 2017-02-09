package com.yamuna.DAO;

import java.util.Iterator;
import java.util.List;

import com.yamuna.exception.PersistantException;
import com.yamuna.model.Department;
import com.yamuna.model.Employee;
import com.yamuna.model.Issue;
import com.yamuna.model.Role;
import com.yamuna.model.Solution;
import com.yamuna.model.UserInfo;
import com.yamuna.util.MailUtil;

public class CreateTicketDAO {
	Issue Issue=new Issue();
	IssueDAO IssueDAO=new IssueDAO();
	
	public void registration(String name,String emailId,String password) throws PersistantException{
		UserInfo userinfo=new UserInfo();
		UserInfoDAO userDao=new UserInfoDAO();
		
		Role role=new Role();
		
		userinfo.setName(name);
		userinfo.setEmailid(emailId);
		userinfo.setPassword(password);
		
		userDao.save(userinfo);
	}
	public void createTicket(String emailId,String password,String subject,String description,String department,String priority) throws PersistantException{

	LoginDAO loginDao=new LoginDAO();
	if(loginDao.login(emailId, password)){
			
		UserInfo userinfo=new UserInfo();
		UserInfoDAO userinformationdao=new UserInfoDAO();
		
		int userId=userinformationdao.findUserId(emailId).getId();
		userinfo.setId(userId);
		Issue.setUSER_ID(userinfo);
		
		Issue.setSUBJECT(subject);
		Issue.setDESCRIPTION(description);
		
		Department departments=new Department();
		DepartmentDAO departmentdao=new DepartmentDAO();
		int departmentId=departmentdao.findId(department).getId();
		departments.setId(departmentId);
		Issue.setDEPARTMENT_ID(departments);
		Issue.setPRIORITY(priority);
		IssueDAO.save(Issue);
		}
	else
	{
		System.out.println("Incorrect user name or password");
	}
}
	
	public void updateTicket(String emailId,String password,int issueId,String updateDescription) throws PersistantException{
		
		LoginDAO loginDao=new LoginDAO();
		if(loginDao.login(emailId, password)){
			UserInfo userinformation=new UserInfo();
			UserInfoDAO userinformationDao=new UserInfoDAO();
			
			int userId=userinformationDao.findUserId(emailId).getId();
			userinformation.setId(userId);
			Issue.setUSER_ID(userinformation);
			
			if("Closed".equals(IssueDAO.findStatus(userId, issueId).getSTATUS()) || "CLOSED".equals(IssueDAO.findStatus(userId, issueId).getSTATUS()) ){
		
			System.out.println("You cant update now!");
			}
		else
		{
	
			Issue.setUSER_ID(userinformation);
		
			Issue.setId(issueId);
			Issue.setSTATUS("Inprogress");
			Issue.setDESCRIPTION(updateDescription);
		
			IssueDAO.updateDescription(Issue);
		}
	}
		else
		{
			System.out.println("Incorrect user name or password");
		}
}
	
	public void updateClose(String emailId,String password,int issueId) throws PersistantException{
		
		LoginDAO loginDao=new LoginDAO();
		if(loginDao.login(emailId, password)){
			
		UserInfo userinfo=new UserInfo();
		UserInfoDAO userinformationdao=new UserInfoDAO();
			
		int userId=userinformationdao.findUserId(emailId).getId();
		userinfo.setId(userId);
		Issue.setUSER_ID(userinfo);
		
		Issue.setId(issueId);
		
		IssueDAO.updateClose(Issue);
		}
		else{
			System.out.println("Incorrect user name or password");
		}
	}
	
	public void findUserDetails(String emailId,String password) throws PersistantException{
		LoginDAO loginDao=new LoginDAO();
		if(loginDao.login(emailId, password)){
			
		UserInfo userinfo=new UserInfo();
		UserInfoDAO userinfoDao=new UserInfoDAO();
			
		int userId=userinfoDao.findUserId(emailId).getId();
		userinfo.setId(userId);
		IssueDAO.findUserDetails(userinfo.getId());
		
		List<Issue> list = IssueDAO.findUserDetails(userId);
		Iterator<Issue> i = list.iterator();
		while (i.hasNext()) {
	    Issue Issue = (Issue) i.next();
			System.out.println(Issue.getId()+ "\t"+Issue.getUSER_ID().getId()+"\t" +Issue.getSUBJECT() + "\t"
					+ Issue.getDESCRIPTION() + "\t"+ Issue.getSTATUS());
		}
		}
		else
		{
			System.out.println("Incorrect user name or password");
		}
		
	}
	
		public void assignEmployee(String emailId, String password, int issueId, int employeeId)throws PersistantException {
			LoginDAO loginDao = new LoginDAO();
			try {
				if (loginDao.employeeLogin(emailId, password)) {
					Employee employee = new Employee();
					employee.setEmailId(emailId);
					employee.setPassword(password);
					EmployeeDAO employeeDao = new EmployeeDAO();
					int currentEmployeeDepartmentId = employeeDao.findEmployeeDepartmentId(emailId, password)
							.getDepartmentId().getId();
					int givenEmployeeDepartmentId = employeeDao.findDepartmentId(employeeId).getDepartmentId().getId();

					if (currentEmployeeDepartmentId == givenEmployeeDepartmentId) {

						Solution solution = new Solution();
						SolutionDAO solutionDao = new SolutionDAO();

						Issue.setId(issueId);
						solution.setIssueId(Issue);

						employee.setId(employeeId);
						solution.setEmployeeId(employee);

						solutionDao.updateEmployeeId(solution);

						IssueDAO.updateStatus(Issue);
					} else {
						System.out.println("Department dosent match");
					}

				}
			} catch (PersistantException e) {
				throw new PersistantException("Login Failed", e);
			}

		}
		public void deleteTickets(String emailId, String password, int issueId) throws PersistantException {
			// TODO Auto-generated method stubpublic void deleteTickets(String emailId, String password, int issueId) throws PersistenceException {
			LoginDAO loginDao = new LoginDAO();
			try {
				if (loginDao.employeeLogin(emailId, password)) {
					Employee employee=new Employee();
					EmployeeDAO employeeDao=new EmployeeDAO();
					employee.setEmailId(emailId);
					employee.setPassword(password);
					int employeeRoleId=employeeDao.findEmployeeRoleId(emailId, password).getRole_id().getId();
					
					Role role=new Role();
					role.setRole("Admin");
					RoleDAO roleDao=new RoleDAO();
					int adminRoleId=roleDao.findRoleId(role).getId();

					if(employeeRoleId==adminRoleId){
						SolutionDAO solutionDao=new SolutionDAO();
						solutionDao.delete(issueId);
						IssueDAO.delete(issueId);
					}
					else{
						System.out.println("You dont have enough rights to delete");
					}
					
					
				}

		}catch (PersistantException e) {
			throw new PersistantException("Login Failed", e);
		}

	}
		public List<Issue> findUserDetails(Issue issue2) {
			// TODO Auto-generated method stubpublic List<Issue> findUserDetails(Issue issue) throws PersistenceException{
			return IssueDAO.findUserDetails(Issue);
		
		}
		public List<com.yamuna.model.Issue> findEmployeeTickets(String emailId, String password) throws PersistantException {
			// TODO Auto-generated method stubpublic List<Issue> findEmployeeTickets(String emailId, String password) throws PersistenceException{
		
			Employee employee=new Employee();
			EmployeeDAO employeeDao=new EmployeeDAO();
			employee.setEmailId(emailId);
			employee.setPassword(password);
			int employeeId=employeeDao.findOne(emailId, password).getId();
			return IssueDAO.findempTickets(employeeId);

	}
		public void ticketSolution(String emailId, String password, int issueId, String ticketSolution) throws PersistantException {
			// TODO Auto-generated method stubpublic void ticketSolution(String emailId, String password, int issueId, String ticketSolution)throws PersistenceException {
			LoginDAO loginDao = new LoginDAO();
			try {
				if (loginDao.employeeLogin(emailId, password)) {
					Employee employee=new Employee();
					employee.setEmailId(emailId);
					employee.setPassword(password);
					EmployeeDAO employeeDao = new EmployeeDAO();

					Solution solution = new Solution();
					SolutionDAO solutionDao = new SolutionDAO();

					if(employeeDao.findOne(emailId, password).getId()==solutionDao.findEmployeeId(issueId).getEmployeeId().getId()){
			
					
					Issue.setId(issueId);
					solution.setIssueId(Issue);
					solution.setSolutionDescription(ticketSolution);

					solutionDao.updateSolution(solution);

					IssueDAO.updateSolutionStatus(Issue);
					}
					else{
						System.out.println("You are not assigned to this issue");
					}
					
					try {
						MailUtil.sendSimpleMail(emailId,"The Solution for your query is as follows:"+ticketSolution+"-"+"Your ticket id is:",issueId);
					} catch (Exception e) {

					}
				}
			} catch (PersistantException e) {
				throw new PersistantException("Login Failed", e);
			}

		}

			
		}
			
		
			
		
		
	

