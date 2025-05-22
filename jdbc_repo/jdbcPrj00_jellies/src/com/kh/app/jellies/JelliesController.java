package com.kh.app.jellies;

import java.util.List;
import java.util.Scanner;

public class JelliesController {
	
	private Scanner sc = new Scanner(System.in);
	private JelliesService jelliesService = new JelliesService();
	
	public void menu() throws Exception {
		int num = -1;
		while(num != 0) {
			printMenu();
			num = ScanNumber();
			callFunction(num);
		}
	}
	
	public void printMenu() {
		System.out.println("---- MENU ----");
		System.out.println("0. 프로그램 종료");
		System.out.println("1. 상품 등록");
		System.out.println("2. 상품 목록 조회");
		System.out.println("3. 상품 상세 조회");
		System.out.println("4. 상품 수정");
		System.out.println("5. 상품 삭제");
	}
	
	
	public int ScanNumber() {
		System.out.println("메뉴 번호");
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	public void callFunction(int num) throws Exception {
		switch (num) {
		case 0 : System.out.println("프로그램 종료"); break;
		case 1 : insert(); break;
		case 2 : update(); break;
		case 3 : delete(); break;
		case 4 : selectList(); break;
		case 5 : selectOne(); break;
		default: System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	//insert
	public void insert() throws Exception {
		//데이터 준비
		System.out.print("flavor : ");
		String flavor = sc.nextLine();
		System.out.print("price : ");
		String price = sc.nextLine();
		
		JelliesVo vo = new JelliesVo();
		vo.setFlavor(flavor);
		vo.setPrice(price);
		
		//서비스 호출
		int result = jelliesService.insert(vo);
		
		//결과 확인
		if(result == 1) {
			System.out.println("상품 등록 완료 !");
		} else {
			System.out.println("상품 등록 실패 ... ");
		}
	}
	//update
	public void update() throws Exception {
		//데이터 준비
		System.out.print("no : ");
		String no = sc.nextLine();
		System.out.print("price : ");
		String price = sc.nextLine();
		
		JelliesVo vo = new JelliesVo();
		vo.setNo(no);
		vo.setPrice(price);
		
		//서비스 호출
		int result = jelliesService.update(vo);
		
		//결과 확인
		if(result == 1) {
			System.out.println("가격 수정 완료 ! ");
		} else {
			System.out.println("가격 수정 실패 ... ");
		}
	}
	//delete
	public void delete() throws Exception {
		//데이터 준비
		System.out.print("no : ");
		String no = sc.nextLine();
		//서비스 호출
		int result = jelliesService.delete(no);
		//결과 확인
		if(result == 1) {
			System.out.println("삭제 성공 ! ");
		} else {
			System.out.println("삭제 실패 ... ");
		}
	}
	//selectList
	public void selectList() throws Exception {
		//데이터 준비
		//서비스 호출
		List<JelliesVo> voList = jelliesService.selectList();
		//결과 확인
		for(JelliesVo x : voList) {
			System.out.println(x);
		}
	}
	//selectOne
	public void selectOne() throws Exception {
		//데이터 준비
		System.out.print("no : ");
		String no = sc.nextLine();
		
		//서비스 호출
		JelliesVo vo = jelliesService.selectOne(no);
		
		//결과 확인
		System.out.println(vo);
		
		
	}

}


//데이터 준비
//서비스 호출
//결과 확인