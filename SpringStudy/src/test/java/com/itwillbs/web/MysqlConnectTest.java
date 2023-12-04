package com.itwillbs.web;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

/**
 * 
 * mysql 과 db 연결을 테스트하기위한 클래스 
 *
 */
public class MysqlConnectTest {

	// 디비연결 정보
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/springdb";
	private static final String DBID="root";
	private static final String DBPW="1234";
	
	//@Test: 테스트하고자 하는 내용을 메서드 안에 작성후 
	//       해당 어노테이션을 작성하면, junit 이 해당코드를 
	//       테스트용 코드로 인식하고 자동 실행 및 테스트 진행
	
	
	
	@Test
	public void testConnection() {
		
		// 1. 드라이버로드
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 로드 실행완료!");
			
		// 2. 디비연결
		try {
			Connection con =  DriverManager.getConnection(DBURL,DBID,DBPW);
			System.out.println("디비연결 성공");
			System.out.println("con" + con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			System.out.println("자원해제 코드 작성");
		}
		
		
		// try-with 구문 => try,catch,finally 한방에 처리
		try(Connection con = DriverManager.getConnection(DBURL,DBID,DBPW);){
			System.out.println("디비연결성공2!");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	


	
	
	
}
