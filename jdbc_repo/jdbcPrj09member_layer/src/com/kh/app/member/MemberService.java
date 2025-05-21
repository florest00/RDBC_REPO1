package com.kh.app.member;

import java.sql.Connection;

import com.kh.app.db.JDBCTemplate;

public class MemberService {
	
	private MemberDAO memberDAO = new MemberDAO();

	public int join(String id, String pwd) throws Exception {
		
		// 비즈니스 로직
		if(id.length() < 4 || pwd.length() < 4) {
			throw new Exception();
		}
		
		// 디비 연결
		Connection conn = JDBCTemplate.getConn();
		
		// DAO 호출
		MemberDAO memberDAO = new MemberDAO();
		int result = memberDAO.join(conn, id, pwd); // 데이터 셋 다 넘겨주면서 DAO 실행
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
	
	//회원 탈퇴
	public int quit(String id, String pwd) throws Exception {
		// 비즈니스 로직
		if(id.length() < 4 || pwd.length() < 4) {
			throw new Exception();
		}
		
		Connection conn = null;
		int result = 0;
		try {
			// 디비 연결 (conn  
			conn = JDBCTemplate.getConn();
			// DAO 호출
			MemberDAO memberDao = new MemberDAO();
			result = memberDao.quit(conn, id, pwd);
			
			// 트랜잭션 처리
			if(result == 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} finally {
			// 자원반납
			conn.close();
		}
		return result;
	}//quit

	public String login(String id, String pwd) throws Exception {
		Connection conn = null;
		String x = null;
		try {
			//비즈니스 로직
			if(id.length() < 4 || pwd.length() < 4) {
				throw new Exception();
			}
			// 디비 연결
			conn = JDBCTemplate.getConn();
			// DAO 호출
			x = memberDAO.login(conn, id, pwd);
			
		} finally {
			conn.close();
		}
		return x;
	}
	
}//class
