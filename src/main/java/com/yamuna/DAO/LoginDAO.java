package com.yamuna.DAO;

import com.yamuna.model.UserInfo;

public class LoginDAO {
	


	



		

		UserInfo userinfo=new UserInfo();
		UserInfoDAO userinfoDao=new UserInfoDAO();
		public boolean login(String emailId,String password){
			String s =userinfoDao.findOne(emailId).getPassword();
			if(s.equals(password))
				return true;
			return false;
			
		}

	}


