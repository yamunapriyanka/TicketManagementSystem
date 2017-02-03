package com.yamuna.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yamuna.model.UserInfo;
import com.yamuna.util.ConnectionUtil;



public class UserInfoDAO {private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


public void save(final UserInfo userinfo) {
	final String sql = "insert UserInfo(ID,NAME,EMAILID,PASSWORD,ISACTIVE) values (?,?,?,?,?)";
	final Object[] params = { userinfo.getId(), userinfo.getName(),userinfo.getEmailid(),userinfo.getPassword(),userinfo.isIsactive() };
	final int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);
}
public void update(final UserInfo userinfo) {
	final String sql = "update userinfo set email=? where id=?";
	final Object[] params = { userinfo.getEmailid(), userinfo.getId() };
	final int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);
}

public void delete(final int id) {
	final String sql = "delete UserInfo where id=?";
    
	final int rows = jdbcTemplate.update(sql, id);
	System.out.println(rows);

}
public List<UserInfo> list() {
	final String sql = "select id,email,password from customer";
	return jdbcTemplate.query(sql, (rs, rowNum) -> {
		final UserInfo userinfo = convert(rs);
		return userinfo;

	});
}
 static UserInfo convert(final ResultSet rs) throws SQLException {
		final UserInfo userinfo = new UserInfo();
		userinfo.setId(rs.getInt("id"));
		userinfo.setEmailid(rs.getString("emailid"));
		userinfo.setPassword(rs.getString("password"));
		return userinfo;
		
}

}
