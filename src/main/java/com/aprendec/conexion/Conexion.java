package com.aprendec.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;


public class Conexion {

	private static BasicDataSource dataSource = null;

	private static void initializeDataSource() {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/crud_java");
		dataSource.setInitialSize(20);
		dataSource.setMaxIdle(15);
		dataSource.setMaxTotal(20);
		dataSource.setMaxWait(Duration.ofMillis(5000));
	}

	private static DataSource getDataSource() {
		if (dataSource == null) {
			initializeDataSource();
		}
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}

}
