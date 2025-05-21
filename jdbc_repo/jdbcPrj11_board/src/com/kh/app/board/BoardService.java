package com.kh.app.board;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.app.util.JDBCTemplate;

public class BoardService {
	
	private BoardDao boardDao = new BoardDao();
	
	public int insert(String title, String content) throws Exception {
		// 디비연결
		Connection conn = JDBCTemplate.getConn();
		
		// DAO 호출
		int result = boardDao.insert(conn, title, content);
		
		// 트랜잭션 처리
		if(result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		
		// 자원 반납
		conn.close();
		return result;
	}

	public int update(String no, String content) throws Exception {
		// 비즈니스 로직
		// 디비연결
		Connection conn = JDBCTemplate.getConn();
		// DAO 호출
		int result = boardDao.update(conn, no, content);
		// 트랜잭션 처리
		if(result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		// 자원 반납 
		conn.close();
		return result;
	}

	public int delete(String no) throws Exception {
		// 비즈니스 로직
		// 디비연결
		Connection conn = JDBCTemplate.getConn();
		// DAO 호출
		int result = boardDao.delete(conn, no);
		// 트랜잭션 처리
		if(result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		// 자원 반납 
		conn.close();
		return result;
	}

	public ArrayList<BoardVo> selectList() throws Exception { // return type : void -->  ArrayList<BoardVo> 
		// 비즈니스 로직
		// 디비연결
		Connection conn = JDBCTemplate.getConn();
		
		// DAO 호출
//		ResultSet rs = boardDao.selectList(conn);
		ArrayList<BoardVo> voList = boardDao.selectList(conn);
		
		// 트랜잭션 처리 // select.. DML이 아니니까 트랜잭션 필요음슴
//		if(rs == 1) {
//			conn.commit();
//		} else {
//			conn.rollback();
//		}
//		return rs;
		
		// 자원 반납 
		conn.close();
		return voList;
	}

	public BoardVo selectOne(String no) throws Exception {
		// 비즈니스 로직
		// 디비연결
		Connection conn = JDBCTemplate.getConn();
		// DAO 호출
		BoardVo vo = boardDao.selectOne(conn, no);
		// 트랜잭션 처리
		// 자원 반납 
		conn.close();
		return vo;
	}

}

/*
// 비즈니스 로직
// 디비연결
// DAO 호출
// 트랜잭션 처리
// 자원 반납 
 */
