package com.yamuna.DAO;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yamuna.model.Role;
import com.yamuna.util.ConnectionUtil;

public class RoleDAO {
JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	public void save(Role role )
	{
		String sql="INSERT INTO ROLE(NAME) VALUES(?)";
		Object[] params={role.getRole()};
		int rows= jdbcTemplate.update(sql, params);
		System.out.println("No. of rows:" +rows);
	}
	public void update(Role role) {

		String sql = "UPDATE ROLE SET NAME=? WHERE ID=?";
		Object[] params = {role.getRole(),role.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(int id) {

		String sql = "DELETE FROM ROLE WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
}