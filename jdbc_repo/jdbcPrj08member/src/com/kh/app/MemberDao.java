package com.kh.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

	// 회원가입
	public int join(Connection conn, String id, String pwd) throws Exception {
		

		// 쿼리 준비
		String sql = "INSERT INTO MEMBER(NO, ID, PWD) VALUES(SEQ_MEMBER.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);

		// 쿼리 실행
		int result = pstmt.executeUpdate();
		// transaction
		if(result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		return result;

		
	}

	// 로그인
	public boolean login(Connection conn, String id, String pwd) throws Exception {
		

		// 쿼리 준비
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);

		// 쿼리 실행
		ResultSet rs = pstmt.executeQuery();

		return rs.next();
	}

}
