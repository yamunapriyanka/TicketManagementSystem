package com.yamuna.util;


	

	import javax.sql.DataSource;


	import org.apache.commons.dbcp2.BasicDataSource;
	import org.springframework.jdbc.core.JdbcTemplate;

	public class ConnectionUtil {
		public static DataSource getDataSource() {
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUsername("root");
			ds.setPassword("chintooo1995");
			ds.setUrl("jdbc:mysql://localhost:3309/yamuna_db");
			return ds;
		}

		public static JdbcTemplate getJdbcTemplate() {
			JdbcTemplate jt = new JdbcTemplate();
			jt.setDataSource(getDataSource());
			return jt;
		}

	}


