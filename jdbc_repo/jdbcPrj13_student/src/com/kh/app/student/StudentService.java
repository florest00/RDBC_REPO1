package com.kh.app.student;

import java.sql.Connection;
import java.util.List;

import com.kh.app.util.JDBCTemplate;

public class StudentService {
	
	private final StudentDao studentDao;
	
	public StudentService() { //생성자 안에서만 할당
		studentDao = new StudentDao();
	}

	public int insert( StudentVo vo) throws Exception {
		//비즈니스 로직
		if( vo.getName().length() < 1) {
			throw new Exception("name 값 길이가 너무 짧음");
		}
		
		if( !vo.getGender().equals("M") && !vo.getGender().equals("F") ) {
			throw new Exception("gender 값은 M 또는 F 만 가능"); //[STUDENT-00n] 원인 뭐 해결방안 뭐
		}
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		//DAO 호출
		int result = StudentDao.insert(conn, vo);
		//트랜잭션 처리
		try {
			if(result != 1) {
				conn.rollback(); 
				throw new Exception("[STUDENT-001] result가 1이 아님"); //[STUDENT-00n] 원인 뭐 해결방안 뭐 -> 엔지니어에게 에러 정보 전달(?) -> 버그 파일/ 에러 로그 잘 작성해두면 좋음
			}
				conn.commit();
		} finally {
			//자원 반납
			conn.close();
		}
		return result;
		
	}

	public StudentVo selectOne(String num) throws Exception {
		//비즈니스 로직
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		//DAO 호출
		StudentVo vo = StudentDao.selectOne(conn, num);
		//트랜잭션 처리
		//자원 반납
		conn.close();
		
		return vo;
	}

	public List<StudentVo> selectList() throws Exception {
		//비즈니스 로직
		//디비연결
		Connection conn = JDBCTemplate.getConn();
		//DAO 호출
		List<StudentVo> voList = StudentDao.selectList(conn, null);
		//트랜잭션 처리
		//자원 반납
		conn.close();
		return voList;
	}

	
	
}

//비즈니스 로직
//디비연결
//DAO 호출
//트랜잭션 처리
//자원 반납