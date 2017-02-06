package com.yamuna.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yamuna.exception.Persistant;
import com.yamuna.model.UserInfo;
import com.yamuna.util.ConnectionUtil;



public class UserInfoDAO {private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


public void save(final UserInfo userinfo) {
	final String sql = "insert USER_INFO(ID,NAME,EMAILID,PASSWORD,ISACTIVE) values (?,?,?,?,?)";
	final Object[] params = { userinfo.getId(), userinfo.getName(),userinfo.getEmailid(),userinfo.getPassword(),userinfo.isIsactive() };
	final int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);
}
public void update(final UserInfo userinfo) {
	final String sql = "update USER_INFO set EMAIL_ID=? where ID=?";
	final Object[] params = { userinfo.getEmailid(), userinfo.getId() };
	final int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);
}

public void delete(final int id) {
	final String sql = "delete USER_INFO where ID=?";
    
	final int rows = jdbcTemplate.update(sql, id);
	System.out.println(rows);

}
public List<UserInfo> list() {
	final String sql = "select * from USER_INFO ";
	return jdbcTemplate.query(sql, (rs, rowNum) -> {
		final UserInfo userinfo = convert(rs);
		return userinfo;

	});
}
 
		
		public UserInfo findOne(int id) {
			String sql = "SELECT ID, NAME,EMAIL_ID,ACTIVE FROM USERS WHERE ID = ?";
			Object[] params = { id };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));

		
}
 public UserInfo findOne(String emailId,String password) throws Persistant{
	   try{
		String sql = "SELECT PASSWORD FROM USER_INFO WHERE EMAIL_ID = ?";
		Object[] params = { emailId,password};
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			UserInfo userinfo=new UserInfo();
			userinfo.setId(rs.getInt("Id"));
			return userinfo;

		} );
	   }
	   catch(EmptyResultDataAccessException e){
			throw new Persistant("Wrong Email id or Password",e);
		}
		}
 public UserInfo findUserId(String emailId) {
		String sql = "SELECT ID FROM USERS WHERE EMAIL_ID = ?";
		Object[] params = { emailId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			UserInfo userinfo=new UserInfo();
			userinfo.setId(rs.getInt("ID"));
			return userinfo;
		
		});

	}
 
 
 static UserInfo convert(final ResultSet rs) throws SQLException {
		final UserInfo userinfo = new UserInfo();
		userinfo.setId(rs.getInt("ID"));
		userinfo.setEmailid(rs.getString("EMAIL_ID"));
		userinfo.setPassword(rs.getString("PASSWORD"));
		return userinfo;
}
 
 
}
