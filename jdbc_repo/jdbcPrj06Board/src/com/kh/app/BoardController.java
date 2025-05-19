package com.kh.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BoardController {
	
	private Scanner sc = new Scanner(System.in);
	
	// 메뉴
	public void menu() throws Exception {
		
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 목록조회");
		System.out.println("3. 게시글 단건조회");
		
		System.out.print("번호 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		switch(num) {
		case 1 : insertBoard(); break;
		case 2 : selectBoard(); break;
		case 3 : selectBoardOne(); break;
		default : System.out.println("잘못누름");
		}
	}
	
	// 게시글 작성
	public void insertBoard() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConn();
		
		//입력
		System.out.print("title : ");
		String title = sc.nextLine();
		System.out.print("content : ");
		String content = sc.nextLine();
		
		//stmt
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BOARD(NO, TITLE, CONTENT) VALUES(SEQ_BOARD.NEXTVAL, ?, ?)");
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		
		//sql
		int result = pstmt.executeUpdate();
		//result
		System.out.println("result : " + result);
	}
	
	
	// 게시글 목록 조회
	public void selectBoard() throws Exception {
		//DB 연결 커넥션 (객체)
		Connection conn = JDBCTemplate.getConn();
		
		//쿼리문 준비
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM BOARD");
		//쿼리문 실행
		ResultSet rs = pstmt.executeQuery();
		
		//실행 결과 확인
		while(rs.next()) { //while 의 조건식
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String created_date = rs.getString("CREATED_DATE"); // 시간을 더하거나 뺄 때 Timestamp가 좋을 수도 있음
			
			System.out.print(no);
			System.out.print(" / ");
			System.out.print(title);
			System.out.print(" / ");
			System.out.print(content);
			System.out.print(" / ");
			System.out.print(created_date);
			System.out.print("\n");
		}
//		System.out.println("실행 결과 : " + rs);
	}

	public void selectBoardOne() throws Exception {
		// 커넥션 준비
		Connection conn = JDBCTemplate.getConn();
		
		System.out.print("조회할 게시글 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		// 쿼리문 준비
		String sql = "SELECT * FROM BOARD WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		
		// 쿼리문 실행
		ResultSet rs = pstmt.executeQuery();
		
		// 실행 결과 확인
//		System.out.println(rs);
		if(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String createdDate = rs.getString("CREATED_DATE");
			System.out.print(no);
			System.out.print(" / ");
			System.out.print(title);
			System.out.print(" / ");
			System.out.print(content);
			System.out.print(" / ");
			System.out.print(createdDate);
			System.out.println();
		}
	}
	
}
