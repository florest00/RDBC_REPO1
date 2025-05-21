package com.kh.app.board;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardController {
	
	private Scanner sc = new Scanner(System.in);
	private BoardService boardService = new BoardService();
	
	//insert
	public void insert() throws Exception {
		// 데이터 준비 (title, content)
		System.out.print("title : ");
		String title = sc.nextLine();
		System.out.print("content : ");
		String content = sc.nextLine();
		// 서비스 호출
		int result = boardService.insert(title, content);
		// 결과 확인
		if(result == 1) {
			System.out.println("게시글 등록 완료 ! ");
		} else {
			System.out.println("게시글 등록 실패 ... ");
		}
	}
	
	//update
	public void update() throws Exception {
		// 데이터 준비
		System.out.print("no : ");
		String no = sc.nextLine();
		System.out.print("content : ");
		String content = sc.nextLine();
		// 서비스 호출
		int result = boardService.update(no, content);
		// 결과 확인
		if(result == 1) {
			System.out.println("게시글 업데이트 성공 ! ");
		} else {
			System.out.println("게시글 업데이트 실패 ... ");
		}
	}
	
	//delete
	public void delete() throws Exception {
		// 데이터 준비
		System.out.print("삭제할 게시글 번호 : ");
		String no = sc.nextLine();
//		int no = Integer.parseInt(sc.nextLine());
		// 서비스 호출
		int result = boardService.delete(no);
		// 결과 확인
		if(result == 1) {
			System.out.println("게시글 삭제 성공 !");
		} else {
			System.out.println("게시글 삭제 실패 ... ");
		}
	}
	
	
	//selectList
	public void selectList() throws Exception {
		// 데이터 준비
		// 게시글 목록 조회 .. 뭔가 이건 상세조회할때
//		System.out.print("조회할 번호 : ");
//		String no = sc.nextLine();
		// 서비스 호출
//		ResultSet rs = boardService.selectList();
		ArrayList<BoardVo> voList = boardService.selectList();
		// 결과 확인
		//향상된 for문 // for(int i = 0; i < voList.size(); ++i)  -->
		for(BoardVo x : voList) {
			System.out.println(x);
//			System.out.println(voList.get(i));
		}
		
		// 객체 형태 vo로 받아와서 결과 확인할 예정  <-- 여러 행의 데이터를 받아올거기 땜시
//		while(rs.next()) {
//			String no = rs.getString(1);
//			String title = rs.getString(2);
//			String content = rs.getString(3);
//			String insert_date = rs.getString(4);
//			
//			System.out.println(no);
//			System.out.println(title);
//			System.out.println(content);
//			System.out.println(insert_date);
//		}
	}
	
	
	//selectOne
	public void selectOne() throws Exception {
		// 데이터 준비
		System.out.print("조회할 번호 : ");
		String no = sc.nextLine();
		// 서비스 호출
		BoardVo vo = boardService.selectOne(no);
		// 결과 확인
		System.out.println(vo);
	}
	
	
}


/*
// 데이터 준비
// 서비스 호출
// 결과 확인
SELECT * FROM BOARD WHERE NO = ? AND DEL_YN = 'N'
 */