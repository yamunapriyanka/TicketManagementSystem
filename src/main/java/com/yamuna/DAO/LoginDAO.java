package com.yamuna.DAO;

import com.yamuna.exception.PersistantException;
import com.yamuna.model.UserInfo;

public class LoginDAO {

	UserInfo userInfo=new UserInfo();
	UserInfoDAO userInfoDAO=new UserInfoDAO();
	public boolean login(String emailId,String password) throws PersistantException{
		String s=userInfoDAO.findOne(emailId,password).getPassword();
		if(s.equals(password))
			return true;
		return false;
	}
	
}