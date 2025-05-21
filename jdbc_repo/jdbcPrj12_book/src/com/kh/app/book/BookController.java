package com.kh.app.book;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class BookController {

	private Scanner sc = new Scanner(System.in);
	private BookService bookService = new BookService();
	
	public void insert() throws Exception {
		//data
		System.out.print("title : ");
		String title = sc.nextLine();
		System.out.print("author : ");
		String author = sc.nextLine();
		System.out.print("price : ");
		String price = sc.nextLine();
		
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setAuthor(author);
		vo.setPrice(price);
		
		//service
		int result = bookService.insert(vo);
		//result
		if(result == 1) {
			System.out.println("도서 등록 완료 !");
		} else {
			System.out.println("도서 등록 실패 ... ");
		}
	}

	public void update() throws Exception {
		//data //UPDATE BOOK SET PRICE = 500 WHERE NO = 1
		System.out.print("no : ");
		String no = sc.nextLine();
		System.out.print("price : ");
		String price = sc.nextLine();
	
		//@.@
		BookVo vo = new BookVo();
		vo.setNo(no);
		vo.setPrice(price);
		
		//service
		int result = bookService.update(vo); //전달할 데이터가 많으면 뭉치기.. 도서 장르 수정하고플 때 유용
		
		//result
		if(result == 1) {
			System.out.println("가격 수정 성공");
		} else {
			System.out.println("가격 수정 실패");
		}
		
	}

	public void delete() throws Exception {
		//data //UPDATE BOOK SET DEL_YN = 'Y' WHERE NO = 1
		System.out.print("no : ");
		String no = sc.nextLine();
		//service
		int result = bookService.delete(no);
		//result
		if(result == 1) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
	}

	public void selectOne() throws Exception {
		//data
		System.out.print("no : ");
		String no = sc.nextLine();
		
		//service
		BookVo vo = bookService.selectOne(no);
		
		//result
		System.out.println(vo);
		
	}

	public void selectList() throws Exception {
		//data
		
		//service
		List<BookVo> voList = bookService.selectList(); //List에는 BookVo만 들어갈거다~
		
		//result
		for( BookVo x : voList ) { //향상된 for문
			System.out.println(x);
		}
		
		
	}

	
	
}
