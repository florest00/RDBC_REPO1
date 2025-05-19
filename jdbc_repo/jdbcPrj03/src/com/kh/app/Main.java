package com.kh.app;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("JDBC ~~~");

		StudentController studentController = new StudentController();
		studentController.menu();
		// jdbc 초점, 그래서 try/catch  x
	}

}
