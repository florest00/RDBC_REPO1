package com.kh.app.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BoardDao {
	
	

	public int insert(Connection conn, String title, String content) throws Exception {
		//쿼리준비
		String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT) VALUES(SEQ_BOARD.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		//쿼리실행
		int result = pstmt.executeUpdate();
		//자원반납
		pstmt.close();
		return result;
	}

	public int update(Connection conn, String no, String content) throws Exception {
		//쿼리준비
		String sql = "UPDATE BOARD SET CONTENT = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, content);
		pstmt.setString(2, no);
		//쿼리실행
		int result = pstmt.executeUpdate();
		//자원반납
		pstmt.close();
		return result;
	}

	public int delete(Connection conn, String no) throws Exception {
		//쿼리준비
		String sql = "UPDATE BOARD SET DEL_YN = 'Y' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, no);
//		pstmt.setString(1, conn);
		pstmt.setString(1, no);
		//쿼리실행
		int result = pstmt.executeUpdate();
		//자원반납 
		pstmt.close();
		return result;
	}

	public ArrayList<BoardVo> selectList(Connection conn) throws Exception {
		//쿼리준비
		String sql = "SELECT * FROM BOARD WHERE DEL_YN = 'N' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//쿼리실행
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<BoardVo> voList = new ArrayList<BoardVo>();
		while(rs.next()) {
			String no = rs.getString(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			String insertDate = rs.getString(4);
			String delYn = rs.getString(5);
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setInsertDate(insertDate);
			vo.setDelYn(delYn);
			
			voList.add(vo);
//			System.out.println(boardVo);
			
//			System.out.print(no);
//			System.out.print(" / ");
//			System.out.print(title);
//			System.out.print(" / ");
//			System.out.print(content);
//			System.out.print(" / ");
//			System.out.print(insertDate);
//			System.out.print(" / ");
//			System.out.print(delYn);
//			System.out.println();
		}
		
		//자원반납 
		rs.close();
		pstmt.close();
		
		return voList;
	}

	public BoardVo selectOne(Connection conn, String no) throws Exception {
		//쿼리준비
		String sql = "SELECT * FROM BOARD WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		//쿼리실행
		ResultSet rs = pstmt.executeQuery();
		
		BoardVo vo = null;
		if(rs.next()) {
//			String no2 = rs.getString("NO"); <-- 어차피 WHERE절에서 가져오니까 주석처리됨
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String insertDate = rs.getString("INSERT_DATE");
			String delYn = rs.getString("DEL_YN");
			
			vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setInsertDate(insertDate);
			vo.setDelYn(delYn);
		}
		rs.next();
		//자원반납 
		rs.close();
		pstmt.close();
		
		return vo;
	}

}

/*
//쿼리준비
//쿼리실행
//자원반납 

 */
