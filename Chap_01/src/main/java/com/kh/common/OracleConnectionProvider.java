package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionProvider {

	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user="khcafe";
	private static final String pw="kh1234";
	
	public static Connection getConnetion() throws SQLException{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			throw new SQLException("JDBC 드라이버를 찾을 수 없습니다.",e);
		}
	}
}
