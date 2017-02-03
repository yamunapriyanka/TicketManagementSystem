package com.yamuna.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yamuna.model.Department;
import com.yamuna.util.ConnectionUtil;

public class DepartmentDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(final Department department) {
		final String sql = "insert DEPARTMENT(ID,NAME,ISACTIVE) values (?,?,?)";
		final Object[] params = { department.getId(), department.getName(), department.isIsactive() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	public void update(final Department department) {
		final String sql = "update DEPARTMENT set NAME=? where ID=?";
		final Object[] params = { department.getId(), department.getName() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	public void delete(final int id) {
		final String sql = "delete DEPARTMENT where ID=?";

		final int rows = jdbcTemplate.update(sql, id);
		System.out.println(rows);

	}

	public List<Department> listdepartment() {
		final String sql = "SELECT * FROM DEPARTMENT";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final Department department = convert(rs);
			return department;

		});

	}

	Department convert(final ResultSet rs) throws SQLException {
		final Department department = new Department();
		department.setId(rs.getInt("ID"));
		department.setName(rs.getString("NAME"));
		department.setIsactive(rs.getBoolean("isactive"));
		return department;

	}
}

// public List<Department> listdepartment;
