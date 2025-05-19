package com.kh.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	
	public static Connection getConn() throws Exception { // static => 객체 생성 없이 메서드 호출 가능
		return  DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
	}
	
}
