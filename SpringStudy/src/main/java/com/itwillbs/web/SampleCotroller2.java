package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleCotroller2 {

  private static final Logger logger = LoggerFactory.getLogger(SampleCotroller2.class);

  	//@RequestMapping(value="/doB", method=RequestMethod.GET)
  	//http://localhost:8088/web/doB
  	//http://localhost:8088/web/doB?msg="ㅎ2"&age=20
  	//? => parameter 보낼때 사용! ==> @ModelAttribute 로 아래처럼 parameter를 보내기가능!
  	// 기본형타입(int 등등..) return 이 불가능! 그런데 String 타입은 return 이 가능!
  	// (==> 나중에 REST 에서 사용가능!!!)
  
  	@GetMapping(value = "/doB")
	public String doB(@ModelAttribute("msg") String msg,
					  @ModelAttribute("age") int age) {
		logger.debug("doB() 호출!");
		
		logger.debug("msg : "+msg); //전달된 파라미터 정보저장
		
		//메서드 return 타입이 String 일 때 => "return 문자".jsp view 페이지로 연결됨!
		return "itwill";
	}
	
	
}
