package com.kh.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentController {
	
	private Scanner sc = new Scanner(System.in);
	
	public void menu() throws Exception {
		int num = -1;
		while(num != 0) {
			printMenu();
			num = scanNumber();
			callFunction(num);
		}
	}
	
	public void printMenu() {
		System.out.println("==== 메뉴 ====");
		System.out.println("0. 프로그램 종료");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 학생 목록 조회");
	}
	
	public int scanNumber() {
		System.out.print("번호 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	public void callFunction(int num) throws Exception {
		switch(num) {
		case 0 :
			System.out.println("프로그램을 종료합니다.");
			break;
		case 1 :
			insertStudent();
			break;
		case 2 :
			updateStudent();
			break;
		case 3 : 
			deleteStudent();
			break;
		case 4 : 
			selectStudent();
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void insertStudent() throws Exception {
		System.out.println("---- insert ----");
		
		//driver 
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//conn
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//		String id = "C##KH";
//		String pwd = "1234";
		// 커넥션 만듬
//		Connection conn = DriverManager.getConnection(url, id, pwd);
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
		//입력 (추상화..)
		System.out.print("학생 이름 : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//sql
//		String sql = "INSERT INTO STUDENT(NAME) VALUES(?)";
//		PreparedStatement pstmt = conn.prepareStatement(sql); //stmt <- sql을 담아주기 위함
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT(NAME) VALUES(?)");
		pstmt.setString(1, str);
		int result = pstmt.executeUpdate();
		
		System.out.println("결과실행 : " + result);
	}
	

	public void updateStudent() throws Exception {
		System.out.println("---- update ----");
		
		//conn
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
		//pstmt
		PreparedStatement pstmt = conn.prepareStatement("UPDATE STUDENT SET NAME = '유재식' WHERE NAME = '유재석'");
		//SQL
		int result = pstmt.executeUpdate();
		
		System.out.println("result  : " + result);
	}
	
	public void deleteStudent() throws Exception {
		System.out.println("---- delete ----");
		//conn
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
		
		//pstmt
		PreparedStatement pstmt = conn.prepareStatement("DELETE STUDENT WHERE NAME ='유재석'");
		//sql
		int result = pstmt.executeUpdate();
		
		System.out.println("result  : " + result);
	}
	
	public void selectStudent() throws Exception {
			System.out.println("---- select ----");
			
			//conn
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
			//pstmt
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM STUDENT"); //WHERE 절로 한명만 나오게 할 수 있음
			//SQL
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String str = rs.getString("NAME");
				System.out.println(str);
			}
		}
}
