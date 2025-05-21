package com.kh.app;

import com.kh.app.jellies.JelliesController;

public class Main {

	public static void main(String[] args) throws Exception {
		
		 System.out.println("==== Skittles Jellies ====");

		JelliesController jelliesController = new JelliesController();
//		jelliesController.insert();
//		jelliesController.update();
//		jelliesController.delete();
//		jelliesController.selectList();
		jelliesController.selectOne();
	}

}
