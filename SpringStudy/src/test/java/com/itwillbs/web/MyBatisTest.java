package com.itwillbs.web;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)



public class MyBatisTest {

	//디비연결, mybatis => sqlSessionFactoryBean 객체 필요
	
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Inject
	private SqlSession sqlSession;
	
	
	@Test
	public void mybatis연결테스트() {
		System.out.println(sqlFactory);
		System.out.println(sqlSession);
		//SqlSession session = sqlFactory.openSession();
		//session.insert(statement);
	}
	
	
	
	
	
}
