package com.kh.app.member;

import java.sql.ResultSet;
import java.util.Scanner;

public class MemberController {
	
	private Scanner sc = new Scanner(System.in);
	private MemberService memberService = new MemberService();
	
	// 메뉴
	public void menu() {
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 회원가입");
		
		System.out.print("메뉴 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		switch(num) {
		case 1 : join(); break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	// 회원가입
	public void join() {
		try {
			// 데이터 준비
			System.out.print("id : ");
			String id = sc.nextLine();
			System.out.print("pwd : ");
			String pwd = sc.nextLine();
			
			// 서비스 호출
//			MemberService memberService = new MemberService();
			int result = memberService.join(id, pwd);
			
			// 결과 확인
			if (result == 1) {
				System.out.println("회원가입 성공 !");
			} else {
				System.out.println("회원가입 실패 ... ");
			}
		}catch(Exception e) {
//			e.printStackTrace(); //빨간 에러 나옴
			// 예외 메세지를 커스터마이징할 수 있음
			System.out.println("회원가입 실패 ... ");
			// catch 블록으로 온거라면 뭔가 잘못됐다는 의미 그래서 실패
		}
 		
	}//method
	
	//회원 탈퇴
	public void quit() {
		
		try {
			// 데이터 준비
			System.out.print("id : ");
			String id = sc.nextLine();
			System.out.print("pwd : ");
			String pwd = sc.nextLine();
			
			// 서비스 호출
//			MemberService memberService = new MemberService();
			int result = memberService.quit(id, pwd); // 필드에 이미 memberService~있으니까 위 코드 지워도 됨
			
			// 유지 보수에 유리하게
			
			
			// 결과 확인
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("탈퇴 성공 !");
//			if(result == 1) {
//				System.out.println("탈퇴 성공 !");
//			} else {
//				throw new Exception();
////				System.out.println("탈퇴 실패 ... ");
//			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("탈퇴 실패 ... ");
		}
		
	}//method
	
	public void login() {
		try {
			//데이터 준비
			System.out.print("id : ");
			String id = sc.nextLine();
			System.out.print("pwd : ");
			String pwd = sc.nextLine();
			
			// 서비스 호출
//			MemberService memberService = new MemberService();
			String x = memberService.login(id, pwd);
			
			// 결과 확인
//			if (x != null) {
//				System.out.println("로그인 성공");
//			} else {
//				System.out.println("로그인 실패");
//			}
			if(x == null) {
				throw new Exception(); // x가 null이 나온건 뭔가 잘못된거기 때문에 예외를 던져준다.
			}
			System.out.println("로그인 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 실패 ... ");
		}
	}
	
}//class
