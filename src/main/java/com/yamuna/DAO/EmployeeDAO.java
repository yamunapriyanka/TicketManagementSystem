package com.yamuna.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yamuna.exception.PersistantException;
import com.yamuna.model.Department;
import com.yamuna.model.Employee;
import com.yamuna.model.Role;
import com.yamuna.util.ConnectionUtil;

public class EmployeeDAO {
 
private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


public void save(final Employee employee) {
	final String sql = "insert into EMPLOYEE (DEPARTMENT_ID,NAME,EMAIL_ID,PASSWORD) values (?,?,?,?)";
	final Object[] params = { employee.getDepartmentId().getId(),employee.getName(),employee.getEmailId(),employee.getPassword() };
	final int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);
}
public void update(final Employee employee) {
	final String sql = "update EMPLOYEE set PASSWORD=? where EMAIL_ID=?";
	final Object[] params = { employee.getPassword(), employee.getEmailId()};
	final int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);
}

public void delete(final int id) {
	final String sql = "delete from EMPLOYEE where ID=?";

	final int rows = jdbcTemplate.update(sql, id);
	System.out.println(rows);

}
public List<Employee> listEmployee() {
	final String sql = "select ID,DEPARTMENT_ID,NAME,EMAIL_ID,PASSWORD,ISACTIVE from EMPLOYEE";
	return jdbcTemplate.query(sql, (rs, rowNum) -> {
		final Employee employee = convert(rs);
		return employee;

	});}

	public Employee findOne(int id) {
		String sql = "SELECT ID,DEPARTMENT_ID,ROLE_ID,NAME,EMAIL,ISACTIVE FROM EMPLOYEE WHERE ID = ?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));

	}
	
	public Employee findOne(String emailId,String password) throws PersistantException {
	
	try{
		String sql = "SELECT ID FROM EMPLOYEE WHERE EMAIL_ID = ? AND PASSWORD=? AND ISACTIVE=1";
		Object[] params = { emailId,password };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) ->{
			Employee employee=new Employee();
			employee.setId(rs.getInt("ID"));
			return employee;
		
		});
		
	}
	catch(EmptyResultDataAccessException e){
		throw new PersistantException("Wrong Email id or Password",e);
	}
}

Employee convert(final ResultSet rs) throws SQLException {
		final Employee employee = new Employee();
		employee.setId(rs.getInt("ID"));
		
		
		Department department= new Department();
		department.setId(rs.getInt("ID"));
		employee.setDepartmentId(department);           		

		employee.setName(rs.getString("NAME"));
		employee.setEmailId(rs.getString("EMAIL_ID"));
		employee.setPassword(rs.getString("PASSWORD"));
		employee.setIsactive(rs.getBoolean("isactive"));
		return employee;
		
}
public Employee findEmployeeDepartmentId(String emailId, String password) {
	// TODO Auto-generated method stubpublic Employee findEmployeeDepartmentId(String emailId,String password) {
	String sql = "SELECT DEPARTMENT_ID FROM EMPLOYEE WHERE EMAIL_ID = ? AND PASSWORD=? AND ISACTIVE=1";
	Object[] params = {emailId,password};
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
		Employee employee=new Employee();
		Department department=new Department();
		department.setId(rs.getInt("DEPARTMENT_ID"));
		employee.setDepartmentId(department);
		return employee;
	});
}


public Employee findDepartmentId(int employeeId) {
	// TODO Auto-generated method stub
	String sql = "SELECT DEPARTMENT_ID FROM EMPLOYEE WHERE ID = ? AND ISACTIVE=1";
	Object[] params = {employeeId};
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
		Employee employee=new Employee();
		Department department=new Department();
		department.setId(rs.getInt("DEPARTMENT_ID"));
		employee.setDepartmentId(department);
		return employee;
	
	});


}
public Employee findEmployeeRoleId(String emailId, String password) {
	String sql = "SELECT ROLE_ID FROM EMPLOYEE WHERE EMAIL_ID = ? AND PASSWORD=? AND ISACTIVE=1";
	Object[] params = {emailId,password};
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
		Employee employee=new Employee();
		Role role=new Role();
		role.setId(rs.getInt("ROLE_ID"));
		employee.setRole_id(role);
		return employee;
	});

}

}
