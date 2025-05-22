package com.kh.app.student;

import java.util.List;
import java.util.Scanner;

public class StudentController {
	
	private final Scanner sc; // 재할당 못하게 final 달아주기 // controller 객체가 저 스캐너를 계속 참조해야 하니
	private final StudentService studentService; // 한번 생성했으면 재할당 필요 없게 final을 추가 // controller 객체가 태어날 때 StudentService라는 객체가 태어나서 연결이 됨

	public StudentController() {
		sc = new Scanner(System.in);
		studentService = new StudentService();
	}
	
	public void menu() {
		int num = -1;
		while(num != -1) {
			printMenu();
			num = scanNumber();
			callFunction(num);
		}
		
	}
	public void printMenu() {
		System.out.println("==== menu ====");
		System.out.println("0. exit");
		System.out.println("1. insert");
		System.out.println("2. update");
		System.out.println("3. delete");
		System.out.println("4. selectList");
		System.out.println("5. selectOne");
	}
	public int scanNumber() {
		System.out.print("menu number : ");
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
	public void callFunction(int num) {
		switch (num) {
		case 0 : System.out.println("sair"); break;
		case 1 : insert(); break;
		case 2 : insert(); break;
		case 3 : insert(); break;
		case 4 : insert(); break;
		case 5 : insert(); break;
		default: System.out.println("numero errado");
		}
	}
	
	
	public void insert() {
		//throw exception 대신 try-catch로 예외처리 
		try {
			//데이터 준비
			System.out.print("name : ");
			String name = sc.nextLine();
			System.out.print("gender : ");
			String gender = sc.nextLine();
			
			//data -> vo (데이터 뭉치기)
			StudentVo vo = new StudentVo();
			vo.setName(name);
			vo.setGender(gender);
			
			//서비스 호출
			int result = studentService.insert(vo);
			//결과 확인
			if(result != 1) {
				throw new Exception("result 값이 1이 아님"); // 비워두면 나중에 캐치블럭에서 실행할때 위배된.. 열 네임 잘못된.. 이런 게 없어서 메세지 찍어주면 좋음 // 파라미터의 메세지가 exception의 부모 생성자에 전달됨
			} 
			System.out.println("등록 성공 ! ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("학생 등록 실패 .... ");
		}
	}
	public void update() {
		//데이터 준비
		//서비스 호출
		//결과 확인
	}
	public void delete() {
		//데이터 준비
		//서비스 호출
		//결과 확인
	}
	public void selectList() throws Exception {
		//데이터 준비
		//서비스 호출
		List<StudentVo> voList = studentService.selectList();
		//결과 확인
		for (StudentVo vo : voList) {
			System.out.println(vo);
		}
		System.out.println(voList);
	}
	public void selectOne() throws Exception {
		//데이터 준비
		System.out.println("num : ");
		String num = sc.nextLine();
		//서비스 호출
		StudentVo vo = studentService.selectOne(num);
		//결과 확인
		System.out.println(vo);
	}
	
}

//데이터 준비
//서비스 호출
//결과 확인
//;
