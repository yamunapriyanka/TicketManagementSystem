
	package com.yamuna.DAO;

	

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;

	import org.springframework.jdbc.core.JdbcTemplate;

import com.yamuna.model.Department;
import com.yamuna.model.Employee;
import com.yamuna.model.TicketTransaction;
import com.yamuna.model.UserInfo;
	import com.yamuna.util.ConnectionUtil;



	public class TicketTransactionDAO  {
		private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


	public void save(final TicketTransaction tickettransaction) {
		final String sql = "insert into TICKET_TRANSACTION (ID,USER_ID,SUBJECT,DESCRIPTION,CREATED_DATE,RESOLVED_DATE,DEPARTMENT_ID,EMPLOYEE_ID,STATUS) values (?,?,?,?,?,?,?,?,?)";
		final Object[] params = { tickettransaction.getId(), tickettransaction.getUserid(),tickettransaction.getSubject(),tickettransaction.getDescription(),tickettransaction.getCreatedDate(),
				tickettransaction.getResolvedDate(),tickettransaction.getDepartmentId().getId(),tickettransaction.getEmployeeId().getId(),tickettransaction.getStatus() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}
	public void update(final TicketTransaction tickettransaction) {
		final String sql = "update TICKET_TRANSACTION set SUBJECT=? where ID=?";
		final Object[] params = { tickettransaction.getSubject(),tickettransaction.getId() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	public void delete(final int id) {
		final String sql = "delete TICKET_TRANSACTION where id=?";
	    
		final int rows = jdbcTemplate.update(sql, id);
		System.out.println(rows);

	}
	public List<TicketTransaction> list() {
		final String sql = "select ID,USER_ID,SUBJECT,DESCRIPTION,CREATED_DATE,RESOLVED_DATE,"
				+ " DEPARTMENT_ID,EMPLOYEE_ID,STATUS from TICKET_TRANSACTION ";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final TicketTransaction tickettransaction = convert(rs);
			return tickettransaction ;

		});
	}
	 static TicketTransaction convert(final ResultSet rs) throws SQLException {
			final TicketTransaction tickettransaction = new TicketTransaction();
			tickettransaction.setId(rs.getInt("id"));
			tickettransaction.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
			tickettransaction.setResolvedDate(rs.getTimestamp("resolved_date").toLocalDateTime());
			tickettransaction.setStatus(rs.getString("status"));
			tickettransaction.setDescription(rs.getString("description"));
			
			
			Department department= new Department();
			tickettransaction.setId(rs.getInt("id"));
			tickettransaction.setDepartmentId(department);     
			
			
			
			Employee employee= new Employee();
			tickettransaction.setId(rs.getInt("id"));
			tickettransaction.setEmployeeId(employee);     
			
			
			
			UserInfo user= new UserInfo();
			tickettransaction.setId(rs.getInt("id"));
			tickettransaction.setUserid(user);     
			
		   return tickettransaction;
			
	}

	}


