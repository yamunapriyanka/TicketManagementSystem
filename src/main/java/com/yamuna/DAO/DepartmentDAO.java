package com.yamuna.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yamuna.exception.Persistant;
import com.yamuna.model.Department;
import com.yamuna.util.ConnectionUtil;

public class DepartmentDAO {

JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
public void save(Department department) throws Persistant {
	try {
		String sql = "INSERT INTO DEPARTMENT(NAME)VALUES(?)";
		Object[] params = { department.getDepartment() };
		jdbcTemplate.update(sql, params);
	} catch (DuplicateKeyException e) {
		throw new Persistant("Given department already exists", e);
	}

}

	public void update(Department department) {

		String sql = "UPDATE DEPARTMENT SET DEPARTMENT=? WHERE ID=?";
		Object[] params = {department.getDepartment(),department.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(int id) {

		String sql = "DELETE FROM DEPARTMENT WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	
	public Department convert(final ResultSet rs) throws SQLException {
		final Department department = new Department();
department.setId(rs.getInt("ID"));
department.setDepartment(rs.getString("NAME"));
department.setActive(rs.getBoolean("ISACTIVE"));
return department;
	}
	
	public List<Department> listdept() {
		String sql = "SELECT * FROM DEPARTMENT";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final Department department= convert(rs);
			return department;
		});
	}
	
	
	public Department findId(String department) {
		String sql = "SELECT ID FROM DEPARTMENT WHERE NAME = ?";
		Object[] params = { department };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) ->{ 
			Department departments = new Department();
			departments.setId(rs.getInt("ID"));
			return departments;
		
		});

	
	}
	
	public int findno(String dept){
		String sql="SELECT ID FROM DEPARTMENT WHERE NAME=?";
		Object[] params = {dept};
	return jdbcTemplate.queryForObject(sql, params, Integer.class);
	
	
	}
}