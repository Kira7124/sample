package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})


public class MemberDAOTest {
	//테스트 전용 클래스
	
	//로거 객체 생성(출력전용 객체)
	//mylogger 단축어
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	

	//MemberDAO 객체가 필요 => memberDAOImpl 객체가 주입(DI)
	
	@Inject
	private MemberDAO mdao;
	
	
	//@Test -> Test 실행하기위한 필수 어노테이션
	//@Test
	public void mybatis_첫쿼리구문실행_테스트() {
		System.out.println("결과 :" + mdao.getTime());
		logger.info("결과 :" + mdao.getTime());
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"); //li 단축어
		logger.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"); //ld 단축어
		

	}
	
	//@Test
	public void 회원가입_테스트() {
		logger.debug("회원가입테스트 시작");
		
		//임시회원정보
		MemberVO vo = new MemberVO();
		vo.setUserid("admin4");
		vo.setUserpw("1234");
		vo.setUsername("관리자");
		vo.setUseremail("admin@admin.com");
		
		mdao.insertMember(vo);
		
		logger.debug("회원가입테스트 끝");
	}
	
	
	//@Test
	public void 로그인_테스트() {
		logger.debug("로그인테스트 시작");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		
		//MemberVO resultVO = mdao.loginMember(vo);
		MemberVO resultVO = mdao.loginMember("admin","1234");
		
		logger.debug("로그인테스트 끝");
		
		if(resultVO !=null) {
			logger.debug("♥로그인성공!!");
		}else {
			logger.debug("凸OTL..로그인실패!!");
		}
	}
	
	//회원정보 단순조회(id이용)
	//@Test
	public void 회원정보조회_테스트() {
		
		logger.debug("사용자의 ID사용해서 회원정보 모두를 조회");
		MemberVO vo = new MemberVO();
		vo.setUserid("admin3");
		
		MemberVO resultVO = mdao.listMember("admin3");
		
		
		logger.debug("사용자의 ID사용해서 회원정보 모두를 조회끝"+ resultVO);

	}
	
	//회원정보 수정
	//@Test
	public void 회원정보수정_테스트() {
		logger.debug("회원정보수정실행");
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUsername("손흥민");
		vo.setUserpw("1234");
		mdao.updateMember(vo);
		logger.debug("회원정보수정실행끝");
		
	}
	
	//회원정보 삭제
	//@Test
	public void 회원정보삭제_테스트() {
		
		
	}
	
	
	//회원정보 리스트 조회
	@Test
	public void 회원정보리스트조회_테스트() {
		logger.debug("회원정보리스트조회_테스트()");
		List<MemberVO> memberList = mdao.getMemberList();
		logger.debug("" + memberList);
		for(MemberVO vo : memberList) {
			logger.debug("id :"+ vo.getUserid()+"//pw:"+ vo.getUserpw());
		}
	}
	
	
	
	
	
	
}





