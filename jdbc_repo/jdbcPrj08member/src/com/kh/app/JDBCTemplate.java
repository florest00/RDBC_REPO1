package com.kh.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {

	public static Connection getConn() throws Exception {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		conn.setAutoCommit(false); // autoCommit 꺼야 "자동 커밋 ~~~" 에러 안남
		return conn;
		// 분리해서 작성해도 문제 X
		// return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
	}
}
