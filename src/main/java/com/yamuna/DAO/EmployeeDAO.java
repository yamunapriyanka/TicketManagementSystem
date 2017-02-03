package com.yamuna.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yamuna.model.Department;
import com.yamuna.model.Employee;

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
public List<Employee> list() {
	final String sql = "select ID,DEPARTMENT_ID,NAME,EMAIL_ID,PASSWORD,ISACTIVE from EMPLOYEE";
	return jdbcTemplate.query(sql, (rs, rowNum) -> {
		final Employee employee = convert(rs);
		return employee;

	});
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

}
