package com.yamuna.service;

import com.yamuna.DAO.LoginDAO;
import com.yamuna.DAO.UserInfoDAO;
import com.yamuna.Validator.UserInfoValidator;
import com.yamuna.exception.PersistantException;
import com.yamuna.exception.ServiceException;
import com.yamuna.exception.ValidatorException;
import com.yamuna.model.UserInfo;


public class UserInfoService {
	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	private LoginDAO loginDAO=new LoginDAO();
	UserInfo userInfo=new UserInfo();

	public void register(String name,String emailid,String password) throws ServiceException {

		try {

			UserInfoValidator.validatateForRegistration(name,emailid,password);
                   userInfoDAO.save(userInfo);
			} 
			

		catch (ValidatorException e) {
			throw new ServiceException("Unable to register", e);
		}
	}
	public boolean login(String emailid,String password) throws ServiceException, PersistantException  {

		try {

			UserInfoValidator.validatateForLogin(emailid,password);
			loginDAO.login(emailid, password);
			
			return true;

		} catch (ValidatorException e) {
			throw new ServiceException("Unable to insert customer", e);
		
		} 
	}
	
	
}
