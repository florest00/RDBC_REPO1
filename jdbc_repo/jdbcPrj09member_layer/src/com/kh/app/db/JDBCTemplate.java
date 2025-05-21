package com.kh.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	public static Connection getConn() throws Exception {
		// 한줄 길어지는 게 싫을 때 이렇게 분리함
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		conn.setAutoCommit(false);
		return conn;
	}
}
