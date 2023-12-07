package com.itwillbs.web;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController3 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
  	//http://localhost:8088/web/doC?userid=admin&gender=남&userpw=1234

	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public void doC(Model model,MemberVO vo/*@ModelAttribute("userid") String userid*/) {
		// MemberVO 객체를 생성하면 자동으로 파라메터 수집(해당 요소)
		
		logger.debug("doC 호출");
		logger.debug("vo :" +vo);
		//logger.debug("userid :"+userid);
		
		
		
		//DB 에서 생성된 데이터
		MemberVO resultVO = new MemberVO(); //resultVO클래스명 => MemberVO 아래 ▼ 참조!!!
		resultVO.setUserid("admin");
		
		
		
		//doC.jsp 페이지로 이동(연결), ==> Model 이라는 객체를 생성 
		//                       ( view <==> Controller 사이의 정보를 전달하는 객체! ) 
		
		
		//model.addAttribute("resultVO",resultVO); ==> resultVO 라는 파라미터이름 안에 
		// resultVO 객체를 담아서 보냄!
		
		
		model.addAttribute(resultVO);
		// => 전달하는 대상의 이름이 없는경우
		// => 전달하는 데이터타입(클래스명) 의 첫 글자를 소문자로 변경후 이름으로 사용함!
		
		
		
	}
	
	
}
