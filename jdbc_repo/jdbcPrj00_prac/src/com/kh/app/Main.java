package com.kh.app;

import com.kh.app.book.BookController;

public class Main {

	public static void main(String[] args) throws Exception {

		BookController bookController = new BookController();
		bookController.insert();
//		bookController.update();
//		bookController.delete();
//		bookController.selectList();
//		bookController.selectOne();
		
	}

}
