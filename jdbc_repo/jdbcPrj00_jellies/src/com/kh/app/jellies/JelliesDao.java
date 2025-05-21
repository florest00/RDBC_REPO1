package com.kh.app.jellies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JelliesDao {

	public static int insert(Connection conn, JelliesVo vo) throws Exception {
		// 쿼리준비
		String sql = "INSERT INTO JELLIES(NO, FLAVOR, PRICE) VALUES(SEQ_JELLIES.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getFlavor());
		pstmt.setString(2, vo.getPrice());
		// 쿼리실행
		int result = pstmt.executeUpdate();

		// 자원반납
		pstmt.close();
		return result;
	}

	public static int update(Connection conn, JelliesVo vo) throws Exception {
		// 쿼리준비
		String sql = "UPDATE JELLIES SET PRICE = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPrice());
		pstmt.setString(2, vo.getNo());

		// 쿼리실행
		int result = pstmt.executeUpdate();

		// 자원반납
		pstmt.close();

		return result;
	}

	public static int delete(Connection conn, String no) throws Exception {
		// 쿼리준비
		String sql = "UPDATE JELLIES SET DEL_YN = 'Y' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		// 쿼리실행
		int result = pstmt.executeUpdate();
		// 자원반납
		pstmt.close();
		return result;

	}

	public static List<JelliesVo> selectList(Connection conn) throws Exception {
		//쿼리준비
		String sql = "SELECT * FROM JELLIES WHERE DEL_YN = 'N' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//쿼리실행
		ResultSet rs = pstmt.executeQuery();
		
		 List<JelliesVo> voList = new ArrayList<JelliesVo>();
		 //rs -> row -> vo -> voList
		 while(rs.next()) {
			 String no = rs.getString("NO");
			 String flavor = rs.getString("FLAVOR");
			 String price = rs.getString("PRICE");
			 String mfg = rs.getString("MFG");
			 String delYn = rs.getString("DEL_YN");
			 
			 JelliesVo vo = new JelliesVo(no, flavor, price, mfg, delYn);
			 
			 voList.add(vo);
		 }
		//자원반납
		 rs.close();
		 pstmt.close();
		 
		 return voList;
	}

	public static JelliesVo selectOne(Connection conn, String no) throws Exception {
		//쿼리준비
		String sql = "SELECT * FROM JELLIES WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		
		//쿼리실행
		ResultSet rs = pstmt.executeQuery();
		
		//rs -> vo
		JelliesVo vo = null;
		if(rs.next()) {
//			String no = rs.getString("NO");
			String flavor = rs.getString("FLAVOR");
			String price = rs.getString("PRICE");
			String mfg = rs.getString("MFG");
			String delYn = rs.getString("DEL_YN");
			
			vo = new JelliesVo(no, flavor, price, mfg, delYn);
		}
		//자원반납
		rs.close();
		pstmt.close();
		
		return vo;
	}
}

//쿼리준비
//쿼리실행
//자원반납
