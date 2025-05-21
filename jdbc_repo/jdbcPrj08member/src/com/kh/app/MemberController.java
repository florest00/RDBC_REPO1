package com.kh.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.sun.net.httpserver.Authenticator.Result;

public class MemberController {

	private Scanner sc = new Scanner(System.in);
	

	// 메뉴
	public void menu() throws Exception {
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");

		System.out.print("번호 입력 : ");
		String num = sc.nextLine(); 
		
		
		switch (num) {
		case "1":
			join();
			break;
		case "2":
			login();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	// 회원가입
	public void join() throws Exception {
		System.out.println("---- join ----");

		// 데이터 준비
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PWD : ");
		String pwd = sc.nextLine();
		
		MemberService service = new MemberService();
		int result = service.join(id, pwd);

		// 결과 확인
		if (result == 1) {
			System.out.println("회원 가입 성공 !!");
		} else {
			System.out.println("회원 가입 실패 ...");
		}
	}

	// 로그인
	public void login() throws Exception {
		System.out.println("---- login ----");

		// 데이터 준비
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PWD : ");
		String pwd = sc.nextLine();
		
		MemberService service = new MemberService();
		boolean isOk = service.login(id, pwd);

		// 결과 확인
		if (isOk) {
			System.out.println("로그인 성공 !! ");
		} else {
			System.out.println("로그인 실패 ...");
		}

	}

}// class
