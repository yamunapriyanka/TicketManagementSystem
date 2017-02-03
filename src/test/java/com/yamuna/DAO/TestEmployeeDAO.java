package com.yamuna.DAO;

import com.yamuna.model.Department;
import com.yamuna.model.Employee;

public class TestEmployeeDAO {

	public static void main(String[] args) {
		Employee employee=new Employee();
EmployeeDAO employeeDAO =new EmployeeDAO();
//employee.setDepartmentId(2);
//employee.setName("nandhini");
//employee.setEmailId("nandhini@gmail.com");
//employee.setPassword("nandhini456");


employeeDAO.save(employee);
//employeeDAO.delete(2);

	}
	

}
