package com.yamuna.DAO;


import com.yamuna.exception.PersistantException;
import com.yamuna.model.UserInfo;

public class TestUserInfoDAO {

	public static void main(String[] args) throws PersistantException {
UserInfo userInfo=new UserInfo();
UserInfoDAO userInformationDAO=new UserInfoDAO();
//userInfo.setEmailId("solai@gmail.com");
//userInfo.setPassword("solai1234");
//userInfoDAO.delete(4);

//		final List<UserInfo> list = userInformationDAO.list();
//      final Iterator<UserInfo> ii = list.iterator();
//      
//      while (ii.hasNext()) {
//			final UserInfo userInformation = (UserInfo) ii.next();
//          System.out.println(userInformation.getId()+"\t"+userInformation.getName()+"\t"+userInformation.getEmailid()+"\t"+userInformation.getPassword()+"\t"+userInformation.isIsactive());
//      }
userInfo.setEmailid("yamuna@gmail.com");
//userInfo.setPassword("yamuna123");

System.out.println(userInformationDAO.findUserId(userInfo.getEmailid()));


	}

}