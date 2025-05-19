package com.kh.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookController {
	
	private Scanner sc = new Scanner(System.in);
	
	//메뉴
	public void menu() throws Exception {
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 수정");
		System.out.println("3. 도서 삭제");
		System.out.println("4. 도서 목록조회");
		System.out.println("5. 도서 상세조회");
		
		System.out.print("번호 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		switch(num) {
		case 1 : insertBook(); break;
		case 2 : updateBook(); break;
		case 3 : deleteBook(); break;
		case 4 : selectBook(); break;
		case 5 : detailBook(); break;
		default : System.out.println("잘못된 번호입니다.");
		}
	}
	
	//도서 등록
	public void insertBook() throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//conn
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
		//input
		System.out.print("title : ");
		String a = sc.nextLine();
		System.out.print("author : ");
		String b = sc.nextLine();
		System.out.print("price : ");
		int c = Integer.parseInt(sc.nextLine());
		//pstmt
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BOOK(TITLE, AUTHOR, PRICE) VALUES(?, ?, ?)");
		pstmt.setString(1, a);
		pstmt.setString(2, b);
		pstmt.setInt(3, c);
		//sql
		int result = pstmt.executeUpdate();
		
		System.out.println("result" + result);
	}
	
	//도서 수정
	public void updateBook() throws Exception {
		//conn
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
		//pstmt
		PreparedStatement pstmt = conn.prepareStatement("UPDATE BOOK SET PRICE = PRICE*1.1"); // 가격 10% 인상
		//SQL
		int result = pstmt.executeUpdate();
		
		System.out.println("result : " + result);
	}
	
	//도서 삭제
	public void deleteBook() throws Exception {
		//conn
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
		//pstmt
		PreparedStatement pstmt = conn.prepareStatement("DELETE BOOK");
		//SQL
		int result = pstmt.executeUpdate();
		
		System.out.println("result : " + result );
	}
	
	//도서 목록조회
	public void selectBook() throws Exception {
		
		//conn
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
		//pstmt
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM BOOK");
		//SQL
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String title = rs.getString("TITLE");
			String author = rs.getString("AUTHOR");
			int price = rs.getInt("PRICE");
			
			System.out.println(title);
			System.out.println(author);
			System.out.println(price);
		}
	}
	
	//도서 상세조회
	public void detailBook() {
		
	}
	
}
