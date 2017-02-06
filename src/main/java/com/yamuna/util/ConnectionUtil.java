package com.yamuna.util;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

	public class ConnectionUtil {

		private ConnectionUtil() {
			throw new IllegalAccessError("Utility class");
		}

		public static DataSource getDataSource() {
			final BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUsername("root");
			ds.setPassword("chintooo1995");
			ds.setUrl("jdbc:mysql://localhost:3309/yamuna_db");
			return ds;
		}

		public static JdbcTemplate getJdbcTemplate()

		{
			final JdbcTemplate jt = new JdbcTemplate();
			jt.setDataSource(getDataSource());
			return jt;
		}
	}
