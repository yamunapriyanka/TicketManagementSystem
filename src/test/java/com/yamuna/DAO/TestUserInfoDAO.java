package com.yamuna.DAO;


import java.util.Iterator;
import java.util.List;


import com.yamuna.model.UserInfo;

public class TestUserInfoDAO {

	public static void main(String[] args) {
//UserInfo userInfo=new UserInfo();
UserInfoDAO userInformationDAO=new UserInfoDAO();
//userInfo.setEmailId("solai@gmail.com");
//userInfo.setPassword("solai1234");
//userInfoDAO.delete(4);

		final List<UserInfo> list = userInformationDAO.list();
      final Iterator<UserInfo> ii = list.iterator();
      
      while (ii.hasNext()) {
			final UserInfo userInformation = (UserInfo) ii.next();
          System.out.println(userInformation.getId()+"\t"+userInformation.getName()+"\t"+userInformation.getEmailid()+"\t"+userInformation.getPassword()+"\t"+userInformation.isIsactive());
      }	

	}

}