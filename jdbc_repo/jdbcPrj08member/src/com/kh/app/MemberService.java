package com.kh.app;

import java.sql.Connection;

public class MemberService {

	// 회원가입
	public int join(String id, String pwd) throws Exception {
		// 비즈니스 로직 (데이터 검증)
				if(id.length() < 4) {
					throw new Exception(); 
				}
				if(pwd.length() < 4) {
					throw new Exception();
				}
				
				// DB
				// 디비 연결
				Connection conn = JDBCTemplate.getConn();
				MemberDao dao = new MemberDao();
				int result = dao.join(conn, id, pwd);
				
				//tx
				conn.commit();
				conn.rollback();
				
				// 자원반납
				conn.close();
				
				return result;
	}
	
	// 로그인
	public boolean login(String id, String pwd) throws Exception {
		// 비즈니스 로직 (데이터 검증)
				if(id.length() < 4) {
					throw new Exception();
				}
				if (pwd.length() < 4) {
					throw new Exception();
				}
				
				// 디비 연결
				Connection conn = JDBCTemplate.getConn();
				// DB 로직 처리
				MemberDao dao = new MemberDao();
				boolean isOk = dao.login(conn, id, pwd);
				
				return isOk;
	}
	
}
