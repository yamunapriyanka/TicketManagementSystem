package com.yamuna.DAO;





import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yamuna.model.Department;

import com.yamuna.model.Issue;
import com.yamuna.model.UserInfo;
import com.yamuna.util.ConnectionUtil;

public class IssueDAO {
 
private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


public void save(final Issue issue) {
	final String sql = "insert into ISSUE (USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY) values (?,?,?,?,?)";
	final Object[] params = { issue.getUSER_ID().getId(),issue.getDEPARTMENT_ID().getId(),issue.getSUBJECT(),issue.getDESCRIPTION(),issue.getSTATUS() };
	final int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);
}
public void updateDescription(Issue Issue) {
	String sql = "UPDATE ISSUES SET DESCRIPTION=?,STATUS='OPEN' WHERE ID=? AND USER_ID=?";
	Object[] params = {Issue.getDESCRIPTION(),Issue.getId(),Issue.getUSER_ID().getId()};
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);

}

public void updateClose(Issue Issue) {
	String sql = "UPDATE ISSUES SET STATUS='CLOSED' WHERE ID=? AND USER_ID=?";
	Object[] params = {Issue.getId(),Issue.getUSER_ID().getId()};
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);

}
public void delete(final int id) {
	final String sql = "delete from ISSUE where ID=?";

	final int rows = jdbcTemplate.update(sql, id);
	System.out.println(rows);
}
public List<Issue> findAll() {
	String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,CREATED_DATE,RESOLVED_DATE,STATUS,PRIORITY FROM TICKET_ISSUES";
	return jdbcTemplate.query(sql, (rs, rowNo) -> {
	
	final Issue ticketIssue = convert(rs);
	return ticketIssue;

});

}

public  List<Issue> findUserDetails(int userId) {
	String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,CREATED_DATE,RESOLVED_DATE,STATUS,PRIORITY FROM TICKET_ISSUES WHERE USER_ID=?";
	Object[] params = { userId };
	return jdbcTemplate.query(sql,params, (rs, rowNo) -> convert(rs));

}

public Issue findOne(int id) {
	String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,CREATED_DATE,RESOLVED_DATE,STATUS,PRIORITY FROM TICKET_ISSUES WHERE ID = ?";
	Object[] params = { id };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));

}

public Issue getStatus(int id) {
	String sql = "SELECT STATUS FROM TICKET_ISSUES WHERE ID=?";
	Object[] params = { id };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
		Issue Issue = new Issue();
		Issue.setSTATUS(rs.getString("STATUS"));
		return Issue;
	});
}


public Issue findStatus(int userId,int id) {
	String sql = "SELECT STATUS FROM ISSUE WHERE USER_ID=? AND ID = ?";
	Object[] params = { userId,id };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
		Issue issue=new Issue();
		issue.setSTATUS(rs.getString("Status"));
		return issue;
	
	});

}
Issue convert(final ResultSet rs) throws SQLException {
		final Issue issue = new Issue();
		issue.setId(rs.getInt("ID"));
		
		
		Department department= new Department();
		department.setId(rs.getInt("ID"));
		issue.setDEPARTMENT_ID(department); 
		
		
		UserInfo userinfo= new UserInfo();
		userinfo.setId(rs.getInt("ID"));
         issue.setUSER_ID(userinfo);
         issue.setSUBJECT(rs.getString("SUBJECT"));
		issue.setDESCRIPTION(rs.getString("DESCRIPTION"));
		issue.setCREATED_DATE(rs.getTimestamp("CREATED_DATE").toLocalDateTime());
		issue.setRESOLVED_DATE(rs.getTimestamp("RESOLVED_DATE").toLocalDateTime());
		issue.setPRIORITY(rs.getString("PRIORITY"));
		
		return issue;
		
}

public List<Issue> findUserDetail(int userId) {
	String sql = "SELECT ID,USER_ID,SUBJECT,DESCRIPTION,CREATED_DATE,STATUS,PRIORITY FROM TICKET_ISSUES WHERE USER_ID=?";
	Object[] params = { userId };
	return jdbcTemplate.query(sql,params, (rs, rowNo) ->{
		Issue ticketIssue=new Issue();
		ticketIssue.setId(rs.getInt("ID"));
		
		UserInfo userinformation=new UserInfo();
		userinformation.setId(rs.getInt("USER_ID"));
		ticketIssue.setUSER_ID(userinformation);
		
		ticketIssue.setSUBJECT(rs.getString("SUBJECT"));
		ticketIssue.setDESCRIPTION(rs.getString("DESCRIPTION"));
		ticketIssue.setSTATUS(rs.getString("STATUS"));
		ticketIssue.setPRIORITY(rs.getString("PRIORITY"));
		return ticketIssue;
	
	});

}


}
