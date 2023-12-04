package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;


//@Repository : 스프링이 해당파일이 MemberDAO 역할을 수행하는 객체로 인식되게 하는코드

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	// 디비연결정보(자동연결,mapper접근...) 처리하는 객체필요
	// => root-context.xml 에서 생성되어있는 객체(빈)를 주입
	@Inject
	private SqlSession sqlSession;
	
	//mapper 의 위치정보 저장
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper";
	
	
	@Override
	public String getTime() {
		//1. 디비연결 
		//2. SQL 구문작성 -> mapper.XML 파일
		//3. SQL 실행
		String time = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		
		System.out.println("SQL 실행완료!");
		System.out.println("time:"+time);
		
		return time;
	}

	@Override
	public void insertMember(MemberVO vo) {
		logger.debug("insertMember(MemberVO vo) 호출 - 시작");
		logger.debug("mybatis가 mapper에 접근 ");
		logger.debug("sql구문 실행");
		logger.debug("sql 구문 실행결과 발생");
		sqlSession.insert(NAMESPACE +".insertMember",vo);
		
		logger.debug("insertMember(MemberVO vo) 호출 - 끝");
		
	}

	@Override
	public MemberVO loginMember(MemberVO vo) {
		logger.debug("loginMember 호출");
		logger.debug("DAO -> mapper 호출");
		
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + ".loginMember",vo);
		
		logger.debug("결과 : "+resultVO);
		
		return resultVO;
	}
	
	
	@Override
	public MemberVO loginMember(String userid, String boardpw) {
		logger.debug("loginMember(String id, String pw) 실행");
//		MemberVO vo = new MemberVO();
//		vo.setUserid(userid);
//		vo.setUserpw(userpw);
		
		//전달된 정보가 하나의 객체(VO) 에 저장이 불가능한경우=> JOIN 을 수행할 때
		// => 하나의 형태로 만들어서 Mapper로 전달하는게 목표!!!
		//Map 컬렉션 사용 ==> 정보를 저장할 때 정보를 쌍으로 저장함!!!
		// => Map<K,V> 컬렉션 사용!!!
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid", userid);
		paramMap.put("userpw", boardpw);
		
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE +".loginMember",paramMap);
		
		
		return resultVO;
	}

	@Override
	public MemberVO listMember(String userid) {
		logger.debug("listMember실행!!");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("userid", userid);
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE +".listMember",paramMap);

		logger.debug("결과 : "+resultVO);

		
		return resultVO;
	}

	@Override
	public void updateMember(MemberVO vo) {
		logger.debug("회원정보수정실행!");
		sqlSession.insert(NAMESPACE +".updateMember",vo);		
		logger.debug("회원정보수정실행완료!");
	}

	@Override
	public List<MemberVO> getMemberList() {
		logger.debug("getMemberList() 호출");
		
		
		return sqlSession.selectList(NAMESPACE+".getList");
	}
	
	
	
	
	
	
	
	
	
	
}
