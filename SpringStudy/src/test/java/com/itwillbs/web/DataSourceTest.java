package com.itwillbs.web;

import java.sql.Connection;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 디비연결 테스트 (Spring - DataSource 를 곁들인 테스트 진행)
 * 
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//=> 스프링으로 테스트하도록세팅
//@ContextConfiguration(
//locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
// )
//=> 스프링에서 설정해놓은 파일의 정보를 불러오기
//


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)



public class DataSourceTest {

	// 디비 연결 정보가 필요함 => 디비연결정보를 의존하고 있음(의존관계-주입)
	//@Inject -> 의존관계의 객체를 주입시켜주는 에노테이션
	
	@Inject
	private DataSource ds;
	
	
	//@Test 테스트하고자하는 메서드에 항상 달아주어야한다!
	
	
	
	@Test
	public void dataSourceTest() {
		System.out.println("의존객체 주입 성공여부 확인!");
		System.out.println(ds);
	}
	
	
	@Test
	public void 디비연결테스트() {
		try {
			Connection con = ds.getConnection();
			System.out.println("디비연결성공");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
