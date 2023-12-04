package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {

	//추상메서드로 처리동작 구현선언
	
	//디비의 시간정보 조회
	public String getTime();
	
	
	//회원가입 처리동작
	public void insertMember(MemberVO vo);
	
	
	//로그인 처리동작
	public MemberVO loginMember(MemberVO vo);
	public MemberVO loginMember(String userid,String userpw);
	
	//회원정보 조회동작
	public MemberVO listMember(String userid);
	
	
	//회원정보수정동작
	public void updateMember(MemberVO vo);
	
	
	//회원정보삭제동작
	
	
	
	//회원정보리스트조회동작
	public List<MemberVO> getMemberList();
	
	
	
	
}
