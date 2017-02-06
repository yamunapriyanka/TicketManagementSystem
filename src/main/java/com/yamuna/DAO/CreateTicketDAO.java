package com.yamuna.DAO;

import java.util.Iterator;
import java.util.List;

import com.yamuna.exception.Persistant;
import com.yamuna.model.Department;
import com.yamuna.model.Issue;
import com.yamuna.model.UserInfo;

public class CreateTicketDAO {
	Issue Issue=new Issue();
	IssueDAO IssueDAO=new IssueDAO();
	
	public void registration(String name,String emailId,String password) throws Persistant{
		UserInfo userinfo=new UserInfo();
		UserInfoDAO userDao=new UserInfoDAO();
		
		userinfo.setName(name);
		userinfo.setEmailid(emailId);
		userinfo.setPassword(password);
		
		userDao.save(userinfo);
	}
	public void createTicket(String emailId,String password,String subject,String description,String department,String priority) throws Persistant{

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
	
	public void updateTicket(String emailId,String password,int issueId,String updateDescription) throws Persistant{
		
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
	
	public void updateClose(String emailId,String password,int issueId) throws Persistant{
		
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
	
	public void findUserDetails(String emailId,String password) throws Persistant{
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

}