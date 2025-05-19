package com.kh.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MemberController {

	private Scanner sc = new Scanner(System.in);

	// 메뉴
	public void menu() throws Exception {
		System.out.println("1. 회원가입");
		System.out.println("2. 회원정보수정");
		System.out.println("3. 회원탈퇴");
		System.out.println("4. 전체 회원 목록 조회 - 관리자만 가능");
		System.out.println("5. 로그인");

		System.out.print("번호 입력 : ");
		int num = Integer.parseInt(sc.nextLine());

		switch (num) {
		case 1:
			join();
			break;
		case 2:
			edit();
			break;
		case 3:
			quit();
			break;
		case 4:
			selectMemberList();
			break;
		case 5:
			login();
			break;
		default:
			System.out.println("잘못누르셨습니다");
		}
	}

	// 멤버 등록 (회원가입)
	public void join() throws Exception {
		System.out.println("---- 회원가입 ----");

		// DB 연결
		Connection conn = JDBCTemplate.getConn();

		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PWD : ");
		String pwd = sc.nextLine();
		
		// 쿼리 준비
		String sql = "INSERT INTO MEMBER(NO, ID, PWD) VALUES(SEQ_MEMBER.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		// 쿼리 실행
		int result = pstmt.executeUpdate();

		// 결과 확인
		if (result == 1) {
			System.out.println("회원가입 성공 ! ");
		} else {
			System.out.println("회원가입 실패 ... ");
		}

	}

	// 멤버 수정 (회원수정)
	public void edit() throws Exception {
		System.out.println("---- 회원수정 ----");
		// DB 연결
		Connection conn = JDBCTemplate.getConn();
		
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("기존 비밀번호 : ");
		String oldPwd = sc.nextLine();
		System.out.print("신규 비밀번호 : ");
		String newPwd = sc.nextLine();
		
		// 쿼리 준비
		String sql = "UPDATE MEMBER SET PWD = ? WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, newPwd);
		pstmt.setString(2, id);
		pstmt.setString(3, oldPwd);
		
		// 쿼리 실행
		int result = pstmt.executeUpdate();
		
		// 결과 확인
		if(result == 1) {
			System.out.println("비밀번호 변경 성공 ! ");
		} else {
			System.out.println("비밀번호 변경 실패 ...");
		}

	}

	// 멤버 삭제 (회원탈퇴)
	public void quit() {
		System.out.println("---- 회원탈퇴 ----");
		// DB 연결
		// 쿼리 준비
		// 쿼리 실행
		// 결과 확인

	}

	// 멤버 목록조회 (전체 회원 목록 조회 - 관리자 기능)
	public void selectMemberList() {
		System.out.println("---- 전체 회원 목록 조회 - 관리자 기능 ----");
		// DB 연결
		// 쿼리 준비
		// 쿼리 실행
		// 결과 확인

	}

	// 멤버 단일조회 - 아이디, 패스워드 이용 (로그인)
	public void login() {
		System.out.println("---- 로그인 ----");
		// DB 연결
		// 쿼리 준비
		// 쿼리 실행
		// 결과 확인
	}

}