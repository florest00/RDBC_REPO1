package com.kh.app;

import com.kh.app.member.MemberController;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("과제");
		
		MemberController memberController = new MemberController();
		memberController.login();
		
	}

}
