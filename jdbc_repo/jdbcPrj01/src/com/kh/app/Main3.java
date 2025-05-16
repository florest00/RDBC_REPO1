package com.kh.app;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main3 {

	public static void main(String[] args) throws Exception {

		System.out.println("Main3");
		
		//driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//conn
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		//SQL : INSERT INTO STUDENT(NAME) VALUES('~~~')
		String sql = "INSERT INTO STUDENT(NAME) VALUES('김태희')";
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
	}

}
