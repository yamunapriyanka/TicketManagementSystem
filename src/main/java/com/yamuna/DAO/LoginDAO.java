package com.yamuna.DAO;

import com.yamuna.exception.PersistantException;

public class LoginDAO {

	  UserInfoDAO userDao=new UserInfoDAO();
	EmployeeDAO employeeDao=new EmployeeDAO();
	public   boolean login(String emailId,String password) throws PersistantException  {
		
			userDao.findOne(emailId,password).getId();
							return true;

	}
	
	
	public boolean employeeLogin(String emailId,String password) throws PersistantException  {
		
		employeeDao.findOne(emailId,password).getId();
						return true;
	
	
}

}