package com.kh.app;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		System.out.println("zzzz");
		
		List db = new ArrayList();
		
		//insert
		db.add("홍길동");
		db.add("김철수");
		db.add("임꺽정");
		db.add("정발산");
		db.add("산기슭");
		
		//select
		System.out.println(db.get(0));
		System.out.println(db.get(1));
		System.out.println(db.get(2));
		System.out.println(db.get(3));
		System.out.println(db.get(4));
	}

}
