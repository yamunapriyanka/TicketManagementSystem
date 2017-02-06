package com.yamuna.DAO;

import com.yamuna.exception.PersistantException;

public class TestLoginDAO {

	public static void main(String[] args) throws PersistantException {
LoginDAO loginDAO=new LoginDAO();
System.out.println(loginDAO.login("rashika@gmail.com","rashika12"));
	}

}