package com.itwillbs.domain;

import java.sql.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// @Data : 필요한 기본 설정값을 지정


//@AllArgsConstructor
//@ToString
//@Setter
//@Getter

@Data
public class MemberVO {
	// Value Object -> DTO 개념으로사용 ( DB 테이블 정보를 저장하는 객체 )
	
	// tbl_member 테이블의 정보를 저장
	
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private Timestamp regdate;
	private Timestamp updatedate;
	
	
	
}




