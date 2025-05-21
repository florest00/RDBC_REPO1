package com.kh.app.member;

import java.sql.Connection;

import com.kh.app.db.JDBCTemplate;

public class MemberService {

	
	private MemberDAO memberDAO = new MemberDAO();
	
	//회원가입
	public int join(String id, String pwd) throws Exception {
		// 디비 연결
		Connection conn = JDBCTemplate.getConn();
		
		// DAO 호출
		int result = memberDAO.join(conn, id, pwd);
		
		// 트랜잭션 처리
		if (result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		
		// 자원 반납
		conn.close();
		
		return result;
	}

	public String login(String id, String pwd) throws Exception {
		//비즈니스 로직
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		
		//DAO 호출
		String x = memberDAO.login(conn, id, pwd);
		
		//트랜잭션 처리
		
		//자원반납
		conn.close();
		
		return x;
	}

}
