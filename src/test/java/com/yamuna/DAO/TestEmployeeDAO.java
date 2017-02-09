package com.yamuna.DAO;

import com.yamuna.model.Employee;

public class TestEmployeeDAO {

	public static void main(String[] args) {
		EmployeeDAO employeeDAO =new EmployeeDAO();
		Employee employee=new Employee();
		//employee.setId(3);
		//employee.setName("Regina");
		//employee.setDeptId(1);
		employee.setEmailId("mumtaj@gmail.com");
		employee.setPassword("mumtaj123@gmail.com");
		//employeeDAO.delete(3);
		System.out.println(employeeDAO.findEmployeeRoleId(employee.getEmailId(), employee.getPassword()));
//		List<Employee> list = employeeDAO.listEmployee();
//		Iterator i = list.iterator();
//		while (i.hasNext()) {
//		Employee employee=(Employee) i.next();
//		System.out.println(employee.getId() + "\t" +employee.getDepartmentId().getId()+employee.getName()+ "\t"+ "\t" +employee.getEmailId()
//		 + "\t"+employee.getPassword()+ "\t" +employee.isIsactive());


	}
	

}