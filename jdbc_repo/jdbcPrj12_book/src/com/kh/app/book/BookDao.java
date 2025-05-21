package com.kh.app.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	public static int insert(String title, String author, String price) {
		// TODO Auto-generated method stub
		return 0;
	}
	//쿼리준비
	//쿼리실행
	//자원반납

	public static int insert(Connection conn, BookVo vo) throws Exception {
		//쿼리준비
		String sql = "INSERT INTO BOOK(NO, TITLE, AUTHOR, PRICE) VALUES(SEQ_BOOK.NEXTVAL , ? , ? , ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getAuthor());
		pstmt.setString(3, vo.getPrice());
		//쿼리실행
		int result = pstmt.executeUpdate();
		//자원반납
		pstmt.close();
		
		return result;
	}

	public static int update(Connection conn, BookVo vo) throws Exception {
		//쿼리준비
		String sql = "UPDATE BOOK SET PRICE = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPrice());
		pstmt.setString(2, vo.getNo());
		//쿼리실행
		int result = pstmt.executeUpdate();
		//자원반납
		pstmt.close();
		
		return result;
	}

	public int delete(Connection conn, String no) throws Exception {
		//쿼리준비
		String sql = "UPDATE BOOK SET DEL_YN = 'Y' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		//쿼리실행
		int result = pstmt.executeUpdate();
		//자원반납
		pstmt.close();
		
		return result;
	}

	public BookVo selectOne(Connection conn, String no) throws Exception {
		//쿼리준비
		String sql = "SELECT * FROM BOOK WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		//쿼리실행 rs -> vo
		ResultSet rs = pstmt.executeQuery();
		
		//rs -> vo
		BookVo vo = null;
		if(rs.next()) {
//			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String author = rs.getString("AUTHOR");
			String price = rs.getString("PRICE");
			String publishedDate = rs.getString("PUBLISHED_DATE");
			String delYn = rs.getString("DEL_YN");
			
			vo = new BookVo(no, title, author, price, publishedDate, delYn);
		}
		
		//자원반납
		rs.close();
		pstmt.close();
		
		return vo;
	}

	public List<BookVo> selectList(Connection conn) throws Exception {
		//쿼리준비
		String sql = "SELECT * FROM BOOK WHERE DEL_YN = 'N' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//쿼리실행
		ResultSet rs = pstmt.executeQuery();
		
		
		List<BookVo> voList = new ArrayList<BookVo>();
		//rs -> row -> vo -> voList
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String author = rs.getString("AUTHOR");
			String price = rs.getString("PRICE");
			String publishedDate = rs.getString("PUBLISHED_DATE");
			String delYn = rs.getString("DEL_YN");
			
			BookVo vo = new BookVo(no, title, author, price, publishedDate, delYn);
			
			voList.add(vo);
		}
		
		//자원반납
		rs.close();
		pstmt.close();
		
		return voList;
	}
}

//쿼리준비
//쿼리실행
//자원반납
