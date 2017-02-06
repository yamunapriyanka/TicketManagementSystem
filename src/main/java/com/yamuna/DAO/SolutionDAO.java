package com.yamuna.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import com.yamuna.model.Employee;
import com.yamuna.model.Issue;
import com.yamuna.model.Solution;
import com.yamuna.util.ConnectionUtil;

public class SolutionDAO {
	
	private JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	public void save(Solution solution) {
	String sql = "INSERT INTO SOLUTION(ISSUE_ID,EMPLOYEE_ID)VALUES(?,?)";
	Object[] params = {solution.getIssueId().getId(),solution.getEmployeeId().getId()};
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);
}
	public void update(Solution solution) {
	String sql = "UPDATE ISSUE SET ISSUE_ID=?,EMPLOYEE_ID=?,RESOLUTION_DESCRIPTION=? WHERE ID=?";
	Object[] params = {solution.getIssueId(),solution.getEmployeeId(),solution.getSolutionDescription(),solution.getId()};
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);

}
	
	public void updateEmployeeId(Solution solution) {
		String sql = "UPDATE SOLUTION SET EMPLOYEE_ID=? WHERE ISSUE_ID=?";
		Object[] params = {solution.getEmployeeId().getId(),solution.getIssueId().getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	}
	
	public void updateSolution(Solution solution) {
		String sql = "UPDATE SOLUTION SET RESOLUTION_DESCRIPTION=? WHERE ISSUE_ID=?";
		Object[] params = {solution.getSolutionDescription(),solution.getIssueId().getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	}
	
	public void delete(int issueId) {
	String sql = "DELETE FROM SOLUTION WHERE ISSUE_ID=?";
	Object params = issueId;
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);

}

	public Solution findEmployeeId(int issueId) {
		String sql = "SELECT EMPLOYEE_ID FROM SOLUTION WHERE ISSUE_ID = ?";
		Object[] params = { issueId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Solution solution = new Solution();
			
			Employee employee=new Employee();
			employee.setId(rs.getInt("EMPLOYEE_ID"));
			solution.setEmployeeId(employee);
				
			return solution;
		});
	}
	
public List<Solution> ListSolution() {
	String sql = "SELECT * FROM SOLUTION";
	return jdbcTemplate.query(sql, (rs, rowNo) -> convert(rs));

}

public Solution findOne(int id) {
	String sql = "SELECT ID,ISSUE_ID,EMPLOYEE_ID,RESOLUTION_DESCRIPTION FROM SOLUTION WHERE ID = ?";
	Object[] params = { id };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));

}

private Solution convert(ResultSet rs) throws SQLException {
	Solution solution = new Solution();
	solution.setId(rs.getInt("ID"));
	
	Issue issue=new Issue();
	issue.setId(rs.getInt("ISSUE_ID"));
	solution.setIssueId(issue);
	
	Employee employee=new Employee();
	employee.setId(rs.getInt("EMPLOYEE_ID"));
	solution.setEmployeeId(employee);
	
	solution.setSolutionDescription(rs.getString("SOLUTION_DESCRIPTION"));
	
	return solution;
}

}



