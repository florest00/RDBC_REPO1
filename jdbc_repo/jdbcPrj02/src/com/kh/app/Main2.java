package com.kh.app;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main2 {

	public static void main(String[] args) throws Exception {

		System.out.println("Main2");
		
		//driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//conn
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		// SQL
		String sql = "INSERT INTO STUDENT(NAME) VALUES('김철수')";
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
	}//main

}//class
