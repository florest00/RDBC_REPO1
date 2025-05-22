package com.kh.app.book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.app.db.JDBCTemplate;

public class BookService {

	public int insert(BookVo vo) throws Exception {
		//비즈니스 로직
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		
		//DAO 호출
		int result = BookDao.insert(conn, vo);
		//트랜잭션 처리
		if(result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		//자원 반납
		conn.close();
		return result;
	}

	public int update(BookVo vo) throws Exception {
		//비즈니스 로직
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		//DAO 호출
		int result = BookDao.update(conn, vo);
		//트랜잭션 처리
		if(result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		//자원 반납
		conn.close();
		return result;
	}

	public int delete(String no) throws Exception {
		//비즈니스 로직
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		//DAO 호출
		int result = BookDao.delete(conn, no);
		//트랜잭션 처리
		if (result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		//자원 반납
		conn.close();
		return result;
	}

	public List<BookVo> selectList() throws Exception {
		//비즈니스 로직
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		//DAO 호출
//		int result = BookDao.selectList();
		List<BookVo> voList = BookDao.selectList(conn); 
		//트랜잭션 처리
		//자원 반납
		conn.close();;
		return voList;
	}

	public BookVo selectOne(String no) throws Exception {
		//비즈니스 로직
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		//DAO 호출
//		int result = BookDao.selectOne();
		BookVo vo = BookDao.selectOne(conn, no);
		//트랜잭션 처리
		//자원 반납
		conn.close();
		
		return vo;
	}

}

//비즈니스 로직
//디비연결
//DAO 호출
//트랜잭션 처리
//자원 반납