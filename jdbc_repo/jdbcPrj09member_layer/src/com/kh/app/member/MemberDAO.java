package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	// 메뉴
	// 회원가입
	public int join(Connection conn, String id, String pwd) throws Exception {
		// 쿼리 준비
		String sql = "INSERT INTO MEMBER(NO, ID, PWD) VALUES(SEQ_MEMBER.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);

		// 쿼리 실행
		int result = pstmt.executeUpdate();

		return result;
	}

	// 회원탈퇴
	public int quit(Connection conn, String id, String pwd) throws Exception { // 메서드 시그니쳐

		// 쿼리 준비
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "UPDATE MEMBER SET DEL_YN='Y' WHERE ID = ? AND PWd = ? AND DEL_YN ='N' ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			// 쿼리 실행
			result = pstmt.executeUpdate();
		} finally {
			pstmt.close();
		}

		return result;

	}// quit

	public String login(Connection conn, String id, String pwd) throws Exception {

		// 쿼리 준비
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN ='N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		// 쿼리 실행
		ResultSet rs = pstmt.executeQuery();

		String x = null;
		if (rs.next()) {
			x = rs.getString(1);
		}
		
		// 자원 반납
		rs.close();
		pstmt.close();
		
		return x;
	}//login

}// class
