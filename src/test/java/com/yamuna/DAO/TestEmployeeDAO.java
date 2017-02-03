package com.yamuna.DAO;

import java.util.Iterator;
import java.util.List;

import com.yamuna.model.Department;
import com.yamuna.model.Employee;

public class TestEmployeeDAO {

	public static void main(String[] args) {
		EmployeeDAO employeeDAO =new EmployeeDAO();
		//employee.setId(3);
		//employee.setName("Regina");
		//employee.setDeptId(1);
		//employee.setEmailId("regina@gmail.com");
		//employee.setPassword("regina1234");
		//employeeDAO.delete(3);
		List<Employee> list = employeeDAO.listEmployee();
		Iterator i = list.iterator();
		while (i.hasNext()) {
		Employee employee=(Employee) i.next();
		System.out.println(employee.getId() + "\t" +employee.getDepartmentId().getId()+employee.getName()+ "\t"+ "\t" +employee.getEmailId()
		 + "\t"+employee.getPassword()+ "\t" +employee.isIsactive());


	}
	

}}