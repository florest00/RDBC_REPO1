package com.kh.app.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookController {
	
	private Scanner sc = new Scanner(System.in);
	private BookService bookService = new BookService();
	
	//insert
	public void insert() throws Exception {
		// 데이터 준비
		System.out.print("title :");
		String title = sc.nextLine();
		System.out.print("author :");
		String author = sc.nextLine();
		System.out.print("price :");
		String price = sc.nextLine();
		
		//객체 생성 및 뭉치기
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setAuthor(author);
		
		// 서비스 호출
		int result = bookService.insert(vo);
		// 결과 확인
		if(result == 1) {
			System.out.println("도서 등록 성공 !");
		} else {
			System.out.println("도서 등록 실패 ... ");
		}
	}
	//update
	public void update() throws Exception {
		// 데이터 준비
		System.out.print("no :");
		String no = sc.nextLine();
		System.out.print("price :");
		String price = sc.nextLine();
		
		// 객체 담고 뭉치기
		BookVo vo = new BookVo();
		vo.setNo(no);
		vo.setPrice(price);
		
		// 서비스 호출
		int result = bookService.update(vo);
		// 결과 확인
		if(result == 1) {
			System.out.println("가격 수정 완료 ! ");
		} else {
			System.out.println("가격 수정 실패 ... ");
		}
	}
	//delete
	public void delete() throws Exception {
		// 데이터 준비
		System.out.print("삭제할 도서 번호 : ");
		String no = sc.nextLine();
		// 서비스 호출
		int result = bookService.delete(no);
		// 결과 확인
		if(result == 1) {
			System.out.println("도서 삭제 완료 ! ");
		} else {
			System.out.println("도서 삭제 실패 ... ");
		}
	}
	//selectList
	public void selectList() throws Exception {
		// 데이터 준비
		// 서비스 호출
//		int result = bookService.selectList();
		List<BookVo> voList= bookService.selectList();
		
		// 결과 확인
		for (BookVo x : voList) {
			System.out.println(x);
		}
		
	}
	//selectOne
	public void selectOne() throws Exception {
		// 데이터 준비
		System.out.print("조회할 도서 번호 : ");
		String no = sc.nextLine();
		// 서비스 호출
//		int result = bookService.selectOne(no);
		BookVo vo = bookService.selectOne(no);
		// 결과 확인
		System.out.println(vo);
	}

}

//데이터 준비
//서비스 호출
//결과 확인