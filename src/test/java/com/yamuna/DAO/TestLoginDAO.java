package com.yamuna.DAO;

import com.yamuna.exception.Persistant;

public class TestLoginDAO {

	public static void main(String[] args) throws Persistant {
LoginDAO loginDAO=new LoginDAO();
System.out.println(loginDAO.login("rashika@gmail.com","rashika12"));
	}

}