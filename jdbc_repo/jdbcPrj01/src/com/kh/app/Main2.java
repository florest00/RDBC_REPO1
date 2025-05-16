package com.kh.app;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main2 {

	public static void main(String[] args) throws Exception {

		System.out.println("==== JDBC ====");

		//driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//conn
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);					// drivermanager 클래스의 getConnection 스태틱 메서드 호출
		
		//SQL
		String sql = "INSERT INTO STUDENT(NAME) VALUES('홍길동')";
		Statement stmt = conn.createStatement();										//스테이트먼트
		stmt.execute(sql);
		
		
	}//main

}//class
