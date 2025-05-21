package com.kh.app;

import com.kh.app.board.BoardController;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("==== BOARD ====");
		
		BoardController boardController = new BoardController();
//		boardController.insert();
//		boardController.update();
//		boardController.delete();
//		boardController.selectList();
		boardController.selectOne();
		
	}

}
