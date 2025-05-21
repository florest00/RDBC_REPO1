package com.kh.app.jellies;

import java.util.List;
import java.util.Scanner;

public class JelliesController {
	
	private Scanner sc = new Scanner(System.in);
	private JelliesService jelliesService = new JelliesService();
	
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