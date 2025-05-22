package com.kh.app.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

	public static int insert(Connection conn, StudentVo vo) throws Exception {
		// 쿼리준비
		String sql = """
				INSERT INTO STUDENT
				(
				    NO
				    ,NAME
				    ,SCORE
				    ,GENDER
				    ,ENROLL_DATE
				    ,DEL_YN
				)
				VALUES
				(
				    SEQ_STUDENT.NEXTVAL
				    , ?
				    , NULL
				    , ?
				    , SYSDATE
				    , DEFAULT
				)
								""";
//		String sql = "INSERT INTO STUDENT(NO, NAME, SCORE, GENDER, ENROLL_DATE, DEL_YN) VALUES(SEQ_STUDENT.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getGender());
		// 쿼리실행
		int result = pstmt.executeUpdate();
		// 자원반납
		pstmt.close();
		return result;
	}

	public static StudentVo selectOne(Connection conn, String num) throws Exception {
		//쿼리준비
		String sql = """
				SELECT * FROM STUDENT WHERE NO = ? AND DEL_YN='N'
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		//쿼리실행
		ResultSet rs = pstmt.executeQuery();
		
		//rs -> vo
		StudentVo vo = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			String score = rs.getString("SCORE");
			String gender = rs.getString("GENDER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");
			
			vo = new StudentVo(no, name, score, gender, enrollDate, delYn);
		}
		

		
		//자원반납
		rs.close();
		pstmt.close();
		
		return vo;
	}

	public static List<StudentVo> selectList(Connection conn, String no) throws Exception {
		//쿼리준비
		String sql = """
				SELECT * FROM STUDENT WHERE DEL_YN='N' ORDER BY NO DESC
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//쿼리실행
		ResultSet rs = pstmt.executeQuery();
		
		//rs -> vo 여러개 -> voList
		rs.next();
//		String no = rs.getString("NO");
		String name = rs.getString("NAME");
		String score = rs.getString("SCORE");
		String gender = rs.getString("GENDER");
		String enrollDate = rs.getString("ENROLL_DATE");
		String delYn = rs.getString("DEL_YN");
		
		StudentVo vo = new StudentVo(no, name, score, gender, enrollDate, delYn);
		
		ArrayList<StudentVo> voList = new ArrayList<StudentVo>();
		voList.add(vo);
		
		//자원반납
		rs.close();
		pstmt.close();
		
		return voList;
	}

}

//쿼리준비
//쿼리실행
//자원반납