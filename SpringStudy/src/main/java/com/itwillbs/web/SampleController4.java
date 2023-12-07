package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	//http://localhost:8088/web/doF
	//http://localhost:8088/web/doD
	//http://localhost:8088/web/doD?msg=itwill

	
	
	@RequestMapping(value = "/doD",method = RequestMethod.GET)
	public String doD(RedirectAttributes rttr/*,Model model*//* @ModelAttribute("msg") String msg*/) {
		logger.debug("doD() 호출");
		
		
		// redirect 할 때만 쓰는 RedirectAttributes rttr 사용해서 보내기
		rttr.addFlashAttribute("msg","아이티윌");
		//model.addAttribute("msg2","itwill");
		
		// addAttribute() : URI 표시 O, (Model, RedirectAttributes) 둘 다 사용가능!
		// ++) F5(새로고침) 시 데이터가 갱신됨 ! (데이터 살아있음)
		// addFlashAttribute() : URI 표시X , (RedirectAttributes) 만 사용가능!
		// ++) F5(새로고침) 시 데이터가 사라짐 ! (데이터 사라짐)
		
		
		
		
		
		// return "redirect:/doE"; 연결되는 view 페이지만 변경 => 단 ,@ModelAttribute("msg") String msg 를 해주면 
		// view 페이지주소에 msg=~ 를 넣어주는것 까지는 가능하다!!! 
		return "redirect:/doE";
		// return "redirect:/doE?msg"+msg ==> ▲ 의 msg=itwill 을 보내기준비 완료  
		//return "redirect:/doE?msg"+msg;
	}
	
	@RequestMapping(value = "/doE",method = RequestMethod.GET)
	public void doE(@ModelAttribute("msg") String msg,
			@ModelAttribute("msg2") String msg2) {
		logger.debug("doE() 호출");
		logger.debug("msg :" + msg);
		logger.debug("msg2 :" +msg2);
	}
	
	
	
	//http://localhost:8088/web/doF?data=1234&data=2222
	// 체크박스 옵션에서 data=1234 , data=2222 처럼 같은 파라미터가 전달될때 ▼
	// 처럼 int [] ~ 배열형태로 바꿔서 출력해주면 아래처럼 같은 이름도 전달해서 출력이 가능하다
	// @RequestParam("data") int data ==> controller 까지만 전달
	// @ModelAttribute("data") int data ==> view 페이지까지 전달
	
	@RequestMapping(value = "/doF",method = RequestMethod.GET)
	public void doF(@RequestParam("data") int[] data/*@ModelAttribute("data") int data*/) {
		logger.debug("doF() 호출");
		
		
		logger.debug("data :" + data[0]);
		logger.debug("data :" + data[1]);
		
	}
	
	
	
}
