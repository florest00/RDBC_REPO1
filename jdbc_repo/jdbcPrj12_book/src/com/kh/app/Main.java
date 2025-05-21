package com.kh.app;

import com.kh.app.book.BookController;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("==== BOOK ====");
		
		BookController bookController = new BookController();
//		bookController.insert();
//		bookController.update();
//		bookController.delete();
//		bookController.selectOne();
		bookController.selectList();
		
		// 불편함을 느껴야 나중에 Spring 할 수 있게 됨... 긴 코드가 한줄이 됨.. 쿼리문도 한 줄로 끝난대 ㅇ.ㅇ!!	
	}

}
