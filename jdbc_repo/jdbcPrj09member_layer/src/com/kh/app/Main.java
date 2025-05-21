package com.kh.app;

import com.kh.app.member.MemberController;

public class Main {

	public static void main(String[] args) {

		System.out.println("JDBC ~ MEMBER ~ LAYER");
		
		MemberController memberController = new MemberController();
		memberController.login();
		
	}

}
