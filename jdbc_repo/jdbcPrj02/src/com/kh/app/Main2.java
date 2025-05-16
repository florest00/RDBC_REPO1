package com.kh.app;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main2 {

	public static void main(String[] args) throws Exception {

		System.out.println("제이디비씨~~~");
		
		//driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//conn
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		//input
		System.out.println("학생 이름 : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		// SQL
		String sql = "INSERT INTO STUDENT(NAME) VALUES(?)"; //입력받을 값 스캐너 // ?
		PreparedStatement pstmt = conn.prepareStatement(sql); // 왜 처음부터 sql? // PreparedStatement는 부모..가 있어서? 바꿀 필요없다?
		pstmt.setString(1, str);
//		pstmt.setString('\n');
//		pstmt.setString(2, "김태희");
//		pstmt.setString(3, "김태희"); // 물음표 여러개라면
		int result = pstmt.executeUpdate(); // stmt.쿼리실행 // sql 지움
		System.out.println("실행결과 : " + result); // 1개 행이 insert 되었습니다
		
		// prepareStatement != executeUpdate ?
	}//main

}//class
