package com.kh.app.jellies;

import java.sql.Connection;
import java.util.List;

import com.kh.app.db.JDBCTemplate;

public class JelliesService {

	public int insert(JelliesVo vo) throws Exception {
		//비즈니스 로직
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		
		//DAO 호출
		int result = JelliesDao.insert(conn, vo);
		
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

	public int update(JelliesVo vo) throws Exception {
		//비즈니스 로직
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		
		//DAO 호출
		int result = JelliesDao.update(conn, vo);
		
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
		int result = JelliesDao.delete(conn, no);
		//트랜잭션 처리
		if(result == 1) {
			conn.commit();
		}else {
			conn.rollback();
		}
		//자원 반납
		return result;
	}

	public List<JelliesVo> selectList() throws Exception {
		//비즈니스 로직
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		//DAO 호출
		List<JelliesVo> voList = JelliesDao.selectList(conn);
		//트랜잭션 처리
		//자원 반납
		conn.close();
		return voList;
	}

	public JelliesVo selectOne(String no) throws Exception {
		//비즈니스 로직
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		//DAO 호출
		JelliesVo vo = JelliesDao.selectOne(conn, no);
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