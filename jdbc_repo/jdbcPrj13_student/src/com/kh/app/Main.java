package com.kh.app;

import com.kh.app.student.StudentController;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("학생 관리 프로그램");
		System.out.println();
		StudentController studentController = new StudentController();
//		studentController.menu();
		
//		studentController.insert();
//		studentController.update();
//		studentController.delete();
		studentController.selectList();
//		studentController.selectOne();
	}

}
